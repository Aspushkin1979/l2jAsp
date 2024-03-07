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
package org.l2jasp.gameserver.network.clientpackets;

import org.l2jasp.commons.network.ReadablePacket;
import org.l2jasp.gameserver.data.sql.CrestTable;
import org.l2jasp.gameserver.enums.CrestType;
import org.l2jasp.gameserver.model.Crest;
import org.l2jasp.gameserver.model.actor.Player;
import org.l2jasp.gameserver.model.clan.Clan;
import org.l2jasp.gameserver.network.GameClient;
import org.l2jasp.gameserver.network.SystemMessageId;

/**
 * Format : chdb c (id) 0xD0 h (subid) 0x11 d data size b raw data (picture i think ;) )
 * @author -Wooden-
 */
public class RequestExSetPledgeCrestLarge implements ClientPacket
{
	private int _length;
	private byte[] _data = null;
	
	@Override
	public void read(ReadablePacket packet)
	{
		_length = packet.readInt();
		if (_length > 2176)
		{
			return;
		}
		
		_data = packet.readBytes(_length);
	}
	
	@Override
	public void run(GameClient client)
	{
		if (_data == null)
		{
			return;
		}
		
		final Player player = client.getPlayer();
		if (player == null)
		{
			return;
		}
		
		final Clan clan = player.getClan();
		if (clan == null)
		{
			return;
		}
		
		if ((_length < 0) || (_length > 2176))
		{
			player.sendMessage("The insignia file size is greater than 2176 bytes.");
			return;
		}
		
		if (clan.getDissolvingExpiryTime() > System.currentTimeMillis())
		{
			player.sendPacket(SystemMessageId.DURING_THE_GRACE_PERIOD_FOR_DISSOLVING_A_CLAN_THE_REGISTRATION_OR_DELETION_OF_A_CLAN_S_CREST_IS_NOT_ALLOWED);
			return;
		}
		
		if ((player.getClanPrivileges() & Clan.CP_CL_REGISTER_CREST) != Clan.CP_CL_REGISTER_CREST)
		{
			player.sendPacket(SystemMessageId.YOU_ARE_NOT_AUTHORIZED_TO_DO_THAT);
			return;
		}
		
		if (_length == 0)
		{
			if (clan.getCrestLargeId() != 0)
			{
				clan.changeLargeCrest(0);
				player.sendPacket(SystemMessageId.THE_CLAN_S_CREST_HAS_BEEN_DELETED);
			}
		}
		else
		{
			if (clan.getLevel() < 3)
			{
				player.sendPacket(SystemMessageId.A_CLAN_CREST_CAN_ONLY_BE_REGISTERED_WHEN_THE_CLAN_S_SKILL_LEVEL_IS_3_OR_ABOVE);
				return;
			}
			
			final Crest crest = CrestTable.getInstance().createCrest(_data, CrestType.PLEDGE_LARGE);
			if (crest != null)
			{
				clan.changeLargeCrest(crest.getId());
				player.sendPacket(SystemMessageId.THE_CLAN_CREST_WAS_SUCCESSFULLY_REGISTERED_REMEMBER_ONLY_A_CLAN_THAT_OWNS_A_CLAN_HALL_OR_CASTLE_CAN_HAVE_THEIR_CREST_DISPLAYED);
			}
		}
	}
}
