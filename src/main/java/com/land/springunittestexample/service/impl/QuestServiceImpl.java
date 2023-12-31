package com.land.springunittestexample.service.impl;

import com.land.springunittestexample.entity.Quest;
import com.land.springunittestexample.repository.QuestRepository;
import com.land.springunittestexample.service.QuestService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    private final QuestRepository questRepository;

    public QuestServiceImpl(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    @Override
    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    @Override
    public Quest getQuestById(Long id) {
        return questRepository.findById(id).orElseThrow();
    }

    @Override
    public Quest saveQuest(Quest quest) {
        return questRepository.save(quest);
    }

    @Override
    public Quest updateQuest(Quest quest) {
        if (questRepository.existsById(quest.getId())) {
            return questRepository.save(quest);
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void deleteQuestById(Long id) {
        questRepository.deleteById(id);
    }
}
