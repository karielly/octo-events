package com.octoevents.dto;

import com.octoevents.model.Issue;

public class IssueDTO {
	
	private Long number;
	private String title;
	private String state;
	
	IssueDTO(){}
	
	private IssueDTO(Long number, String title, String state) {
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
	
	public Issue mapperToIssue() {
		return Issue.of(number, title, state);

	}
	
	public static IssueDTO of(Long number, String title, String state) {
		return new IssueDTO(number, title, state);
	}
}
