package com.youcruit.ams.api.client.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MatchListProcessingException extends JsonProcessingException {
    private static final long serialVersionUID = -5712164821523837070L;

    public MatchListProcessingException(String msg, Throwable rootCause) {
	super(msg, rootCause);
    }

}
