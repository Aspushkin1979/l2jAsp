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

import org.l2jasp.gameserver.data.sql.CharInfoTable;
import org.l2jasp.gameserver.model.World;
import org.l2jasp.gameserver.model.actor.Player;
import org.l2jasp.gameserver.network.GameClient;
import org.l2jasp.gameserver.network.SystemMessageId;
import org.l2jasp.gameserver.network.serverpackets.SystemMessage;

public class RequestFriendList implements ClientPacket
{
	@Override
	public void run(GameClient client)
	{
		final Player player = client.getPlayer();
		if (player == null)
		{
			return;
		}
		
		// ======<Friend List>======
		player.sendPacket(SystemMessageId.FRIENDS_LIST);
		
		for (int id : player.getFriendList())
		{
			final String friendName = CharInfoTable.getInstance().getNameById(id);
			if (friendName == null)
			{
				continue;
			}
			
			final Player friend = World.getInstance().getPlayer(id);
			player.sendPacket(SystemMessage.getSystemMessage(((friend == null) || !friend.isOnline()) ? SystemMessageId.S1_CURRENTLY_OFFLINE : SystemMessageId.S1_CURRENTLY_ONLINE).addString(friendName));
		}
		
		// =========================
		player.sendPacket(SystemMessageId.EMPTY_3);
	}
}
