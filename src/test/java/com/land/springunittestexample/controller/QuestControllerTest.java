package com.land.springunittestexample.controller;

import com.land.springunittestexample.controller.QuestController;
import com.land.springunittestexample.entity.Quest;
import com.land.springunittestexample.service.QuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuestControllerTest {

    @InjectMocks
    private QuestController questController;

    @Mock
    private QuestService questService;

    private Quest quest;

    @BeforeEach
    public void setUp() {
        quest = new Quest();
        quest.setId(0L);
        quest.setTitle("Ayın fısıltısı.");
        quest.setDescription("Karakterin gelişimi için önemli bir görev.");
        quest.setContent("3 tane aç alfa mavi kurt kes.");
        quest.setRequiredLevel("10");
        quest.setReward("3 tane kılıç");
        quest.setRewardExp(100L);
    }

    @Test
    public void testGetAllQuests() {
        List<Quest> quests = new ArrayList<>();
        when(questService.getAllQuests()).thenReturn(quests);

        List<Quest> returnedQuests = questController.getAllQuests();

        assertThat(returnedQuests).isNotNull();
        assertThat(returnedQuests.size()).isEqualTo(quests.size());
    }

    @Test
    public void testGetQuestById() {
        when(questService.getQuestById(1L)).thenReturn(quest);

        Quest returnedQuest = questController.getQuestById(1L);

        assertThat(returnedQuest).isNotNull();
        assertThat(returnedQuest.getId()).isEqualTo(quest.getId());
    }

    @Test
    public void testCreateQuest() {
        when(questService.saveQuest(any(Quest.class))).thenReturn(quest);

        Quest returnedQuest = questController.saveQuest(quest);

        assertThat(returnedQuest).isNotNull();
        assertThat(returnedQuest.getId()).isEqualTo(quest.getId());
    }

    @Test
    public void testUpdateQuest() {
        when(questService.updateQuest(any(Quest.class))).thenReturn(quest);

        Quest returnedQuest = questController.updateQuest(quest);

        assertThat(returnedQuest).isNotNull();
        assertThat(returnedQuest.getId()).isEqualTo(quest.getId());
    }

    @Test
    public void testDeleteQuest() {
        questController.deleteQuest(0L);

        verify(questService, times(1)).deleteQuestById(0L);
    }
}
