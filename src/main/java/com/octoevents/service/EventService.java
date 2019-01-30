package com.octoevents.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octoevents.dto.EventDTO;
import com.octoevents.model.Event;
import com.octoevents.model.Issue;
import com.octoevents.repository.EventRepository;
import com.octoevents.repository.IssueRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	public EventDTO save(EventDTO eventDto) {
		Event event = eventDto.mapperToEvent();
		Issue issue = event.getIssue();
		issueRepository.save(issue);
		return eventRepository.save(event).getEventDTO();
	}
	
	public List<EventDTO> getEventsByIssue(Long numberIssue) {
		Issue issue = Issue.of(numberIssue, null, null);
		List<Event> events = eventRepository.findByIssue(issue);
		return events.stream().map(e -> e.getEventDTO()).collect(Collectors.toList());
	}
}
