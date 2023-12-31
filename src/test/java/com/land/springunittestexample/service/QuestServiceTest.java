package com.land.springunittestexample.service;

import com.land.springunittestexample.entity.Quest;
import com.land.springunittestexample.repository.QuestRepository;
import com.land.springunittestexample.service.impl.QuestServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class QuestServiceTest {
    @InjectMocks
    private QuestServiceImpl questService;
    @Mock
    private QuestRepository questRepository;

    private Quest quest;

    @BeforeEach
    public void setUpData() {

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
    public void QuestService_CreateQuest_ReturnsQuest() {
        when(questRepository.save(any(Quest.class))).thenReturn(quest);
        Quest returnedQuest = questService.saveQuest(quest);
        assertThat(returnedQuest).isNotNull();

    }

    @Test
    public void QuestService_GetAllQuests_ReturnsQuest() {
        List<Quest> quests = new ArrayList<>();
        when(questRepository.findAll()).thenReturn(quests);

        List<Quest> returnedQuests = questService.getAllQuests();

        assertThat(returnedQuests).isNotNull();
    }

    @Test
    public void QuestService_GetQuestById_ReturnsQuest() {
        when(questRepository.findById(1L)).thenReturn(Optional.of(quest));

        Quest returnedQuest = questService.getQuestById(1L);
        assertThat(returnedQuest).isNotNull();
    }

    @Test
    public void QuestService_UpdateQuest_ReturnsQuest() {

        when(questRepository.existsById(0L)).thenReturn(true);
        when(questRepository.save(any(Quest.class))).thenReturn(quest);

        Quest returnedQuest = questService.updateQuest(quest);

        assertThat(returnedQuest).isNotNull();
    }

    @Test
    public void QuestService_DeleteById_ReturnsVoid() {

        Assertions.assertAll(() -> questService.deleteQuestById(0L));
        verify(questRepository).deleteById(quest.getId());
    }

    @Test
    public void QuestService_UpdateQuest_ThrowEntityNotFoundException() {
        when(questRepository.existsById(0L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> {
            Quest returnedQuest = questService.updateQuest(quest);
        });
    }

}
