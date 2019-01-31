package com.octoevents.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.octoevents.exception.MessageException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
    private MessageSource messageSource;
    
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
			HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String messageUser = messageSource.getMessage("message.invalid.properties", null, LocaleContextHolder.getLocale());
        String messageDev = ex.toString();
        return handleExceptionInternal(ex, MessageException.of(messageUser, messageDev), new HttpHeaders(), HttpStatus.UNSUPPORTED_MEDIA_TYPE, request);
    }

    @ExceptionHandler({ DataIntegrityViolationException.class } )
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        String messageUser = messageSource.getMessage("resource.operation-not-allowed", null, LocaleContextHolder.getLocale());
        String messageDev = ex.toString();
        return handleExceptionInternal(ex, MessageException.of(messageUser, messageDev), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
    @ExceptionHandler({ EntityExistsException.class } )
    public ResponseEntity<Object> handleEntityExistsException(EntityExistsException ex, WebRequest request) {
        String messageUser = "teste";
        String messageDev = ex.toString();
        return handleExceptionInternal(ex, MessageException.of(messageUser, messageDev), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
    	String messageUser = messageSource.getMessage("resource.not-found", null, LocaleContextHolder.getLocale());
        String messageDev = ex.toString();
        return handleExceptionInternal(ex, MessageException.of(messageUser, messageDev), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<MessageException> errosArgumentsInvalids = ex.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> {
                    String msgUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                    String msgDev = fieldError.toString();
                    return MessageException.of(msgUser, msgDev);
                }).collect(Collectors.toList());

        return handleExceptionInternal(ex, errosArgumentsInvalids, headers, status, request);
    }
}
