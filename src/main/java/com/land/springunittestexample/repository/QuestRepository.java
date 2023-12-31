package com.land.springunittestexample.repository;

import com.land.springunittestexample.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends JpaRepository<Quest,Long> {
}
