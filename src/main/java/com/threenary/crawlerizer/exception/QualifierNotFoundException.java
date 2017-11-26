package com.threenary.crawlerizer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be trhown in case the qualifier is not loaded in the system
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This qualifier is not suppoert yet in the system")
public class QualifierNotFoundException extends Exception
{

    private static final long serialVersionUID = 1L;


    public QualifierNotFoundException(String message)
    {
        super(message);
    }

}
