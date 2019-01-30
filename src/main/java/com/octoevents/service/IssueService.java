package com.octoevents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octoevents.repository.IssueRepository;

@Service
public class IssueService {
	
	@Autowired
	private IssueRepository issueRepository;

}
