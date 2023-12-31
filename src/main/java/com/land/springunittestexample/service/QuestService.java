package com.land.springunittestexample.service;

import com.land.springunittestexample.entity.Quest;

import java.util.List;

public interface QuestService {

    List<Quest> getAllQuests();
    Quest getQuestById(Long id);
    Quest saveQuest(Quest quest);
    Quest updateQuest(Quest quest);
    void deleteQuestById(Long id);

}
