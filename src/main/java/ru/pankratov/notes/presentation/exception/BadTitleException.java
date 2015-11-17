package ru.pankratov.notes.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Очень плохой заголовок")
public class BadTitleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1442126354770068606L;

}
