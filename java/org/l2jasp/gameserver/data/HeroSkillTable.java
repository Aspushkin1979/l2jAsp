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
package org.l2jasp.gameserver.data;

import org.l2jasp.gameserver.model.Skill;

/**
 * @author Asp
 */
public class HeroSkillTable
{
	private static final Skill[] HERO_SKILLS = new Skill[]
	{
		SkillTable.getInstance().getSkill(395, 1),
		SkillTable.getInstance().getSkill(396, 1),
		SkillTable.getInstance().getSkill(1374, 1),
		SkillTable.getInstance().getSkill(1375, 1),
		SkillTable.getInstance().getSkill(1376, 1)
	};
	
	public static Skill[] getHeroSkills()
	{
		return HERO_SKILLS;
	}
}
