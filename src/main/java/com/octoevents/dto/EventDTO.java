package com.octoevents.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.octoevents.model.Event;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class EventDTO implements Serializable {

	private static final long serialVersionUID = -4677649669833606394L;

	private Long id;
	private String action;
	private IssueDTO issueDto;
	private Date createdAt;
	private Date updatedAt;
	
	EventDTO(){}
	
	private EventDTO(Long id, String action, IssueDTO issueDto, Date createdAt, Date updatedAt) {
		this.id = id;
		this.action = action;
		this.issueDto = issueDto;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}
	
	@JsonProperty("issue")
	public IssueDTO getIssueDto() {
		return issueDto;
	}

	public String getAction() {
		return action;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public Event mapperToEvent() {
		return Event.of(action, issueDto.mapperToIssue());
	}
	
	public static EventDTO of(Long id, String action, IssueDTO issueDto, Date createdAt, Date updatedAt) {
		return new EventDTO(id, action, issueDto, createdAt, updatedAt);
	}
	
}
