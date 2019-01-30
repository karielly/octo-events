package com.octoevents.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<EventDTO> post(@RequestBody EventDTO event) {
		EventDTO eventSave = eventService.save(event);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventSave);
	}
	
	@GetMapping("/teste")
	public String getHello() {
		return "Hello";
	}
}
