package com.octoevents.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.octoevents.dto.EventDTO;
import com.octoevents.service.EventService;

@RestController
@RequestMapping("/issues")
public class IssueResource {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("{number}/events")
	public ResponseEntity<List<EventDTO>> getEventsByNumber(@PathVariable Long number) {
		List<EventDTO> events = eventService.getEventsByIssue(number);
		return ResponseEntity.status(HttpStatus.OK).body(events);
	}

}
