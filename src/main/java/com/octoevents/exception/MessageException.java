package com.octoevents.exception;

import java.io.Serializable;

public class MessageException implements Serializable {

	private static final long serialVersionUID = -6034820242476888466L;
	
	private String messageUser;
    private String messageDeveloper;

    private MessageException(String messageUser, String messageDeveloper) {
        this.messageUser = messageUser;
        this.messageDeveloper = messageDeveloper;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public String getMessageDeveloper() {
        return messageDeveloper;
    }

    public static MessageException of(String messageUser, String messageDeveloper) {
        return new MessageException(messageUser, messageDeveloper);
    }

}
