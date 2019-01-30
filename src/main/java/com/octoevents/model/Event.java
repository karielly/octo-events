package com.octoevents.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.octoevents.dto.EventDTO;

@Entity
@Table(name = "event")
public class Event implements Serializable {

	private static final long serialVersionUID = 3355973206580384626L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long id;
	
	@Column(name = "ACTION")
	private String action;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "FK_ISSUE")
	private Issue issue;
	
	@Column(name = "CREATED_AT")
	private Date createdAt;
	
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	
	Event(){}
	
	private Event(String action, Issue issue) {
		this.action = action;
		this.issue = issue;
	}

	public Long getId() {
		return id;
	}

	public String getAction() {
		return action;
	}

	public Issue getIssue() {
		return issue;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
    protected void setValuesPrePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
	
	@PreUpdate
    protected void setValuesPreUpdate() {
        this.updatedAt = new Date();
    }
	
	public static Event of(String action, Issue issue) {
		return new Event(action, issue);
	}
	
	public EventDTO getEventDTO() {
		return EventDTO.of(id, action, issue.getIssueDTO());
	}
}
