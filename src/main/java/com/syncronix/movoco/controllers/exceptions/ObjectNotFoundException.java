package com.syncronix.movoco.controllers.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String message){

        super(message);
    }
}
