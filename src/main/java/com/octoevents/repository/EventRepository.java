package com.octoevents.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.octoevents.model.Event;
import com.octoevents.model.Issue;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	List<Event> findByIssue(Issue issue);
}
