package com.octoevents.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.octoevents.dto.IssueDTO;

@Entity
@Table(name = "issue")
public class Issue implements Serializable {

	private static final long serialVersionUID = 5513550892513892701L;
	
	@Id
	@Column(name = "NUMBER")
	private Long number;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "STATE")
	private String state;
	
	Issue(){}
	
	private Issue(Long number, String title, String state) {
		this.number = number;
		this.title = title;
		this.state = state;
	}

	public Long getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public String getState() {
		return state;
	}
	
	public static Issue of(Long number, String title, String state) {
		return new Issue(number, title, state);
	}
	
	public IssueDTO getIssueDTO() {
		return IssueDTO.of(number, title, state);
	}
	
}
