/*
 * This file is part of the L2J Asp project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2jasp.gameserver.handler.skillhandlers;

import java.util.List;

import org.l2jasp.gameserver.data.ItemTable;
import org.l2jasp.gameserver.handler.ISkillHandler;
import org.l2jasp.gameserver.model.Skill;
import org.l2jasp.gameserver.model.actor.Attackable;
import org.l2jasp.gameserver.model.actor.Creature;
import org.l2jasp.gameserver.model.actor.Player;
import org.l2jasp.gameserver.model.holders.ItemHolder;
import org.l2jasp.gameserver.model.item.instance.Item;
import org.l2jasp.gameserver.model.skill.SkillType;
import org.l2jasp.gameserver.network.SystemMessageId;
import org.l2jasp.gameserver.network.serverpackets.InventoryUpdate;
import org.l2jasp.gameserver.network.serverpackets.SystemMessage;

/**
 * @author _drunk_ TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates
 */
public class Sweep implements ISkillHandler
{
	private static final SkillType[] SKILL_TYPES =
	{
		SkillType.SWEEP
	};
	
	@Override
	public void useSkill(Creature creature, Skill skill, List<Creature> targets)
	{
		if (!(creature instanceof Player))
		{
			return;
		}
		
		final Player player = (Player) creature;
		final InventoryUpdate iu = new InventoryUpdate();
		boolean send = false;
		for (Creature target1 : targets)
		{
			if (!(target1 instanceof Attackable))
			{
				continue;
			}
			
			final Attackable target = (Attackable) target1;
			List<ItemHolder> items = null;
			boolean isSweeping = false;
			synchronized (target)
			{
				if (target.isSweepActive())
				{
					items = target.takeSweep();
					isSweeping = true;
				}
			}
			
			if (isSweeping)
			{
				if ((items == null) || items.isEmpty())
				{
					continue;
				}
				for (ItemHolder ritem : items)
				{
					if (player.isInParty())
					{
						player.getParty().distributeItem(player, ritem, true, target);
					}
					else
					{
						if (ItemTable.getInstance().createDummyItem(ritem.getId()).isStackable())
						{
							final int existingCount = player.getInventory().getInventoryItemCount(ritem.getId(), -1);
							final Item item = player.getInventory().addItem("Sweep", ritem.getId(), ritem.getCount(), player, target);
							if (existingCount > 0)
							{
								iu.addModifiedItem(item);
								send = true;
							}
						}
						else
						{
							for (int i = 0; i < ritem.getCount(); i++)
							{
								player.addItem("Sweep", ritem.getId(), 1, null, false);
							}
						}
						
						SystemMessage smsg;
						if (ritem.getCount() > 1)
						{
							smsg = new SystemMessage(SystemMessageId.YOU_HAVE_EARNED_S2_S1_S);
							smsg.addItemName(ritem.getId());
							smsg.addNumber(ritem.getCount());
						}
						else
						{
							smsg = new SystemMessage(SystemMessageId.YOU_HAVE_EARNED_S1);
							smsg.addItemName(ritem.getId());
						}
						player.sendPacket(smsg);
					}
				}
			}
			target.endDecayTask();
			
			if (send)
			{
				player.sendPacket(iu);
			}
		}
	}
	
	@Override
	public SkillType[] getSkillTypes()
	{
		return SKILL_TYPES;
	}
}
