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
package org.l2jasp.gameserver.taskmanager;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import org.l2jasp.Config;
import org.l2jasp.commons.threads.ThreadPool;
import org.l2jasp.gameserver.enums.ItemLocation;
import org.l2jasp.gameserver.instancemanager.ItemsOnGroundManager;
import org.l2jasp.gameserver.model.World;
import org.l2jasp.gameserver.model.item.instance.Item;
import org.l2jasp.gameserver.model.item.type.EtcItemType;

public class ItemsAutoDestroyTaskManager implements Runnable
{
	protected static final Logger LOGGER = Logger.getLogger(ItemsAutoDestroyTaskManager.class.getName());
	
	private static final Set<Item> ITEMS = ConcurrentHashMap.newKeySet();
	
	protected ItemsAutoDestroyTaskManager()
	{
		ThreadPool.scheduleAtFixedRate(this, 5000, 5000);
	}
	
	@Override
	public void run()
	{
		if (ITEMS.isEmpty())
		{
			return;
		}
		
		final long currentTime = System.currentTimeMillis();
		final Iterator<Item> iterator = ITEMS.iterator();
		Item itemInstance;
		
		while (iterator.hasNext())
		{
			itemInstance = iterator.next();
			if ((itemInstance == null) || (itemInstance.getDropTime() == 0) || (itemInstance.getItemLocation() != ItemLocation.VOID))
			{
				iterator.remove();
			}
			else if (itemInstance.getItemType() == EtcItemType.HERB)
			{
				if ((currentTime - itemInstance.getDropTime()) > Config.HERB_AUTO_DESTROY_TIME)
				{
					World.getInstance().removeVisibleObject(itemInstance, itemInstance.getWorldRegion());
					World.getInstance().removeObject(itemInstance);
					iterator.remove();
					
					if (Config.SAVE_DROPPED_ITEM)
					{
						ItemsOnGroundManager.getInstance().removeObject(itemInstance);
					}
				}
			}
			else if ((currentTime - itemInstance.getDropTime()) > (Config.AUTODESTROY_ITEM_AFTER * 1000))
			{
				World.getInstance().removeVisibleObject(itemInstance, itemInstance.getWorldRegion());
				World.getInstance().removeObject(itemInstance);
				iterator.remove();
				
				if (Config.SAVE_DROPPED_ITEM)
				{
					ItemsOnGroundManager.getInstance().removeObject(itemInstance);
				}
			}
		}
	}
	
	public void addItem(Item item)
	{
		item.setDropTime(System.currentTimeMillis());
		ITEMS.add(item);
	}
	
	public static ItemsAutoDestroyTaskManager getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
	
	private static class SingletonHolder
	{
		protected static final ItemsAutoDestroyTaskManager INSTANCE = new ItemsAutoDestroyTaskManager();
	}
}
