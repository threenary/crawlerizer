package com.threenary.crawlerizer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be trhown in case the url received is malformed or null
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This url is not possible to process")
public class UnsuportedURLException extends Exception
{

    private static final long serialVersionUID = 1L;


    public UnsuportedURLException(String message)
    {
        super(message);
    }


    public UnsuportedURLException(String message, Exception e)
    {
        super(message, e);
    }

}
