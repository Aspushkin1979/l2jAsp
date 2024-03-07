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
package ai.others;

import org.l2jasp.gameserver.enums.ChatType;
import org.l2jasp.gameserver.model.actor.Npc;
import org.l2jasp.gameserver.model.actor.Player;
import org.l2jasp.gameserver.model.quest.Quest;
import org.l2jasp.gameserver.network.serverpackets.CreatureSay;

/**
 * @author Asp
 * @note Based on python script
 */
public class OlMahumGeneral extends Quest
{
	// NPC
	private static final int OL_MAHUM_GENERAL = 20438;
	
	private OlMahumGeneral()
	{
		super(-1, "ai/others");
		
		addAttackId(OL_MAHUM_GENERAL);
	}
	
	@Override
	public String onAttack(Npc npc, Player attacker, int damage, boolean isPet)
	{
		if (npc.isScriptValue(1))
		{
			if (getRandom(100) < 10)
			{
				npc.broadcastPacket(new CreatureSay(npc.getObjectId(), ChatType.GENERAL, npc.getName(), "We shall see about that!"));
			}
		}
		else
		{
			npc.setScriptValue(1);
			npc.broadcastPacket(new CreatureSay(npc.getObjectId(), ChatType.GENERAL, npc.getName(), "I will definitely repay this humiliation!"));
		}
		return super.onAttack(npc, attacker, damage, isPet);
	}
	
	public static void main(String[] args)
	{
		new OlMahumGeneral();
	}
}
