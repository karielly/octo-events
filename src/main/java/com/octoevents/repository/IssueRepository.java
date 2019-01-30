package com.octoevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.octoevents.model.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

}
