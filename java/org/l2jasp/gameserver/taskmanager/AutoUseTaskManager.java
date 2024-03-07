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

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.l2jasp.Config;
import org.l2jasp.commons.threads.ThreadPool;
import org.l2jasp.gameserver.handler.IItemHandler;
import org.l2jasp.gameserver.handler.ItemHandler;
import org.l2jasp.gameserver.model.Skill;
import org.l2jasp.gameserver.model.WorldObject;
import org.l2jasp.gameserver.model.actor.Creature;
import org.l2jasp.gameserver.model.actor.Playable;
import org.l2jasp.gameserver.model.actor.Player;
import org.l2jasp.gameserver.model.actor.Summon;
import org.l2jasp.gameserver.model.actor.instance.Guard;
import org.l2jasp.gameserver.model.item.ItemTemplate;
import org.l2jasp.gameserver.model.item.instance.Item;
import org.l2jasp.gameserver.model.skill.SkillTargetType;
import org.l2jasp.gameserver.model.zone.ZoneId;
import org.l2jasp.gameserver.util.Util;

/**
 * @author Asp
 */
public class AutoUseTaskManager
{
	private static final Set<Set<Player>> POOLS = ConcurrentHashMap.newKeySet();
	private static final int POOL_SIZE = 300;
	private static final int TASK_DELAY = 300;
	
	protected AutoUseTaskManager()
	{
	}
	
	private class AutoUse implements Runnable
	{
		private final Set<Player> _players;
		
		public AutoUse(Set<Player> players)
		{
			_players = players;
		}
		
		@Override
		public void run()
		{
			if (_players.isEmpty())
			{
				return;
			}
			
			for (Player player : _players)
			{
				if (!player.isOnline() || (player.isInOfflineMode() && !player.isOfflinePlay()))
				{
					stopAutoUseTask(player);
					continue;
				}
				
				if (player.isSitting() || player.isStunned() || player.isSleeping() || player.isParalyzed() || player.isAfraid() || player.isAlikeDead() || player.isMounted())
				{
					continue;
				}
				
				final boolean isInPeaceZone = player.isInsideZone(ZoneId.PEACE);
				
				if (Config.ENABLE_AUTO_ITEM && !isInPeaceZone)
				{
					ITEMS: for (Integer itemId : player.getAutoUseSettings().getAutoSupplyItems())
					{
						if (player.isTeleporting())
						{
							break ITEMS;
						}
						
						final Item item = player.getInventory().getItemByItemId(itemId.intValue());
						if (item == null)
						{
							player.getAutoUseSettings().getAutoSupplyItems().remove(itemId);
							continue ITEMS;
						}
						
						final ItemTemplate it = item.getTemplate();
						if (it != null)
						{
							for (Skill skill : it.getAllSkills())
							{
								if (player.isSkillDisabled(skill, false))
								{
									continue ITEMS;
								}
							}
						}
						
						final IItemHandler handler = ItemHandler.getInstance().getItemHandler(itemId);
						if (handler != null)
						{
							handler.useItem(player, item);
						}
					}
				}
				
				if (Config.ENABLE_AUTO_POTION && !isInPeaceZone && (player.getCurrentHpPercent() < player.getAutoPlaySettings().getAutoPotionPercent()))
				{
					final int itemId = player.getAutoUseSettings().getAutoPotionItem();
					if (itemId > 0)
					{
						final Item item = player.getInventory().getItemByItemId(itemId);
						if (item == null)
						{
							player.getAutoUseSettings().setAutoPotionItem(0);
						}
						else
						{
							boolean disabled = false;
							final ItemTemplate it = item.getTemplate();
							if (it != null)
							{
								for (Skill skill : it.getAllSkills())
								{
									if (player.isSkillDisabled(skill, false))
									{
										disabled = true;
										break;
									}
								}
							}
							
							if (!disabled)
							{
								final IItemHandler handler = ItemHandler.getInstance().getItemHandler(itemId);
								if (handler != null)
								{
									handler.useItem(player, item);
								}
							}
						}
					}
				}
				
				if (Config.ENABLE_AUTO_SKILL)
				{
					BUFFS: for (Integer skillId : player.getAutoUseSettings().getAutoBuffs())
					{
						// Fixes start area issue.
						if (isInPeaceZone)
						{
							break BUFFS;
						}
						
						// Already casting.
						if (player.isCastingNow())
						{
							break BUFFS;
						}
						
						// Player is teleporting.
						if (player.isTeleporting())
						{
							break BUFFS;
						}
						
						Playable pet = null;
						Skill skill = player.getKnownSkill(skillId.intValue());
						if (skill == null)
						{
							final Summon summon = player.getPet();
							if (summon != null)
							{
								skill = summon.getKnownSkill(skillId.intValue());
								if (skill != null)
								{
									pet = summon;
								}
							}
							if (skill == null)
							{
								player.getAutoUseSettings().getAutoBuffs().remove(skillId);
								continue BUFFS;
							}
						}
						
						final WorldObject target = player.getTarget();
						if (canCastBuff(player, target, skill))
						{
							// Playable target cast.
							final Playable caster = pet != null ? pet : player;
							if ((target != null) && target.isPlayable() && (target.getActingPlayer().getPvpFlag() == 0) && (target.getActingPlayer().getKarma() <= 0))
							{
								caster.doCast(skill);
							}
							else // Target self, cast and re-target.
							{
								final WorldObject savedTarget = target;
								caster.setTarget(caster);
								caster.doCast(skill);
								caster.setTarget(savedTarget);
							}
						}
					}
					
					// Continue when auto play is not enabled.
					if (!player.isAutoPlaying())
					{
						continue;
					}
					
					SKILLS:
					{
						// Already casting.
						if (player.isCastingNow())
						{
							break SKILLS;
						}
						
						// Player is teleporting.
						if (player.isTeleporting())
						{
							break SKILLS;
						}
						
						// Acquire next skill.
						Playable pet = null;
						final Integer skillId = player.getAutoUseSettings().getNextSkillId();
						Skill skill = player.getKnownSkill(skillId.intValue());
						if (skill == null)
						{
							final Summon summon = player.getPet();
							if (summon != null)
							{
								skill = summon.getKnownSkill(skillId.intValue());
								if (skill != null)
								{
									pet = summon;
								}
							}
							if (skill == null)
							{
								player.getAutoUseSettings().getAutoSkills().remove(skillId);
								player.getAutoUseSettings().resetSkillOrder();
								break SKILLS;
							}
						}
						
						// Casting on self stops movement.
						final WorldObject target = player.getTarget();
						if (target == player)
						{
							break SKILLS;
						}
						
						// Check bad skill target.
						if ((target == null) || ((Creature) target).isDead())
						{
							break SKILLS;
						}
						
						// Peace zone and auto attackable checks.
						if ((target.isCreature() && ((Creature) target).isInsideZone(ZoneId.PEACE)) || !target.isAutoAttackable(player))
						{
							break SKILLS;
						}
						
						// Do not attack guards.
						if (target instanceof Guard)
						{
							final int targetMode = player.getAutoPlaySettings().getNextTargetMode();
							if ((targetMode != 3 /* NPC */) && (targetMode != 0 /* Any Target */))
							{
								break SKILLS;
							}
						}
						
						if (!canUseMagic(player, target, skill) || (pet != null ? pet : player).useMagic(skill, true, false))
						{
							player.getAutoUseSettings().incrementSkillOrder();
						}
					}
				}
			}
		}
		
		private boolean canCastBuff(Player player, WorldObject target, Skill skill)
		{
			if ((target != null) && target.isCreature() && ((Creature) target).isAlikeDead() && (skill.getTargetType() != SkillTargetType.SELF) && (skill.getTargetType() != SkillTargetType.CORPSE) && (skill.getTargetType() != SkillTargetType.CORPSE_PLAYER))
			{
				return false;
			}
			
			final Playable playableTarget = (target == null) || !target.isPlayable() || (skill.getTargetType() == SkillTargetType.SELF) ? player : (Playable) target;
			if ((player != playableTarget) && (Util.calculateDistance(player, playableTarget, true) > skill.getCastRange()))
			{
				return false;
			}
			
			if (!skill.isOffensive() && (playableTarget.getFirstEffect(skill) != null))
			{
				return false;
			}
			
			if (!canUseMagic(player, playableTarget, skill))
			{
				return false;
			}
			
			return true;
		}
		
		private boolean canUseMagic(Player player, WorldObject target, Skill skill)
		{
			if ((skill.getItemConsume() > 0) && (player.getInventory().getInventoryItemCount(skill.getItemConsumeId(), -1) < skill.getItemConsume()))
			{
				return false;
			}
			
			if ((skill.getMpConsume() > 0) && (player.getCurrentMp() < skill.getMpConsume()))
			{
				return false;
			}
			
			return !player.isSkillDisabled(skill, false) && skill.checkCondition(player, target, false);
		}
	}
	
	public synchronized void startAutoUseTask(Player player)
	{
		for (Set<Player> pool : POOLS)
		{
			if (pool.contains(player))
			{
				return;
			}
		}
		
		for (Set<Player> pool : POOLS)
		{
			if (pool.size() < POOL_SIZE)
			{
				pool.add(player);
				return;
			}
		}
		
		final Set<Player> pool = ConcurrentHashMap.newKeySet(POOL_SIZE);
		pool.add(player);
		ThreadPool.scheduleAtFixedRate(new AutoUse(pool), TASK_DELAY, TASK_DELAY);
		POOLS.add(pool);
	}
	
	public void stopAutoUseTask(Player player)
	{
		player.getAutoUseSettings().resetSkillOrder();
		for (Set<Player> pool : POOLS)
		{
			if (pool.remove(player))
			{
				return;
			}
		}
	}
	
	public static AutoUseTaskManager getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
	
	private static class SingletonHolder
	{
		protected static final AutoUseTaskManager INSTANCE = new AutoUseTaskManager();
	}
}
