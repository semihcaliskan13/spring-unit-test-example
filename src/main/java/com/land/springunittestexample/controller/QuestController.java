package com.land.springunittestexample.controller;

import com.land.springunittestexample.entity.Quest;
import com.land.springunittestexample.service.QuestService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
public class QuestController {

    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping
    public List<Quest> getAllQuests() {
        return questService.getAllQuests();
    }

    @GetMapping(value = "{id}")
    public Quest getQuestById(@PathVariable Long id) {
        return questService.getQuestById(id);
    }

    @PostMapping
    public Quest saveQuest(@RequestBody Quest quest) {
        return questService.saveQuest(quest);
    }

    @PutMapping
    public Quest updateQuest(@RequestBody Quest quest) {
        return questService.updateQuest(quest);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuest(@PathVariable Long id){
        questService.deleteQuestById(id);
    }
}
