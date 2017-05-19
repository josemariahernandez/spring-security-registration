package com.personal.demo.exception;

/**
 * Created by Chema on 18/05/2017.
 */
@SuppressWarnings("serial")
public class EmailExistsException extends Throwable{
    public EmailExistsException(final String message){
        super(message);
    }
}
