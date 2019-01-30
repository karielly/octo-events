package com.octoevents.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.octoevents.dto.EventDTO;
import com.octoevents.service.EventService;

@RestController
@RequestMapping("/events")
public class EventResource {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping
	public EventDTO post(@RequestBody EventDTO event) {
		return eventService.save(event);
	}
}
