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
package quests.Q608_SlayTheEnemyCommander;

import org.l2jasp.gameserver.model.actor.Npc;
import org.l2jasp.gameserver.model.actor.Player;
import org.l2jasp.gameserver.model.quest.Quest;
import org.l2jasp.gameserver.model.quest.QuestState;
import org.l2jasp.gameserver.model.quest.State;

public class Q608_SlayTheEnemyCommander extends Quest
{
	// Quest Items
	private static final int HEAD_OF_MOS = 7236;
	private static final int TOTEM_OF_WISDOM = 7220;
	private static final int KETRA_ALLIANCE_4 = 7214;
	
	public Q608_SlayTheEnemyCommander()
	{
		super(608, "Slay the enemy commander!");
		registerQuestItems(HEAD_OF_MOS);
		addStartNpc(31370); // Kadun Zu Ketra
		addTalkId(31370);
		addKillId(25312); // Mos
	}
	
	@Override
	public String onAdvEvent(String event, Npc npc, Player player)
	{
		String htmltext = event;
		final QuestState st = player.getQuestState(getName());
		if (st == null)
		{
			return htmltext;
		}
		
		if (event.equals("31370-04.htm"))
		{
			st.startQuest();
		}
		else if (event.equals("31370-07.htm"))
		{
			if (st.hasQuestItems(HEAD_OF_MOS))
			{
				st.takeItems(HEAD_OF_MOS, -1);
				st.giveItems(TOTEM_OF_WISDOM, 1);
				st.rewardExpAndSp(10000, 0);
				st.playSound(QuestState.SOUND_FINISH);
				st.exitQuest(true);
			}
			else
			{
				htmltext = "31370-06.htm";
				st.setCond(1);
				st.playSound(QuestState.SOUND_ACCEPT);
			}
		}
		
		return htmltext;
	}
	
	@Override
	public String onTalk(Npc npc, Player player)
	{
		String htmltext = getNoQuestMsg();
		final QuestState st = player.getQuestState(getName());
		if (st == null)
		{
			return htmltext;
		}
		
		switch (st.getState())
		{
			case State.CREATED:
			{
				if (player.getLevel() >= 75)
				{
					if ((player.getAllianceWithVarkaKetra() >= 4) && st.hasQuestItems(KETRA_ALLIANCE_4) && !st.hasQuestItems(TOTEM_OF_WISDOM))
					{
						htmltext = "31370-01.htm";
					}
					else
					{
						htmltext = "31370-02.htm";
					}
				}
				else
				{
					htmltext = "31370-03.htm";
				}
				break;
			}
			case State.STARTED:
			{
				htmltext = (st.hasQuestItems(HEAD_OF_MOS)) ? "31370-05.htm" : "31370-06.htm";
				break;
			}
		}
		
		return htmltext;
	}
	
	@Override
	public String onKill(Npc npc, Player player, boolean isPet)
	{
		for (Player partyMember : getPartyMembers(player, npc, 1))
		{
			if (partyMember.getAllianceWithVarkaKetra() >= 4)
			{
				final QuestState st = partyMember.getQuestState(getName());
				if (st == null)
				{
					continue;
				}
				
				if (st.hasQuestItems(KETRA_ALLIANCE_4))
				{
					st.setCond(2);
					st.playSound(QuestState.SOUND_MIDDLE);
					st.giveItems(HEAD_OF_MOS, 1);
				}
			}
		}
		
		return null;
	}
}