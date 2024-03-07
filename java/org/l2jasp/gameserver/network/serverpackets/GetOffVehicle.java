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
package org.l2jasp.gameserver.network.serverpackets;

import org.l2jasp.gameserver.model.actor.Player;
import org.l2jasp.gameserver.network.ServerPackets;

/**
 * @author Maktakien
 */
public class GetOffVehicle extends ServerPacket
{
	private final Player _player;
	private final int _boatId;
	private final int _x;
	private final int _y;
	private final int _z;
	
	public GetOffVehicle(Player player, int boatId, int x, int y, int z)
	{
		_player = player;
		_boatId = boatId;
		_x = x;
		_y = y;
		_z = z;
		_player.setBoat(null);
	}
	
	@Override
	public void write()
	{
		ServerPackets.GET_OFF_VEHICLE.writeId(this);
		writeInt(_player.getObjectId());
		writeInt(_boatId);
		writeInt(_x);
		writeInt(_y);
		writeInt(_z);
	}
}
