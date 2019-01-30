package com.octoevents.exception;

import javax.persistence.PersistenceException;

public class EntityExistException extends PersistenceException {

	private static final long serialVersionUID = -4827794826560016146L;
	
	public EntityExistException(String message) {
        super(message);
    }
}
