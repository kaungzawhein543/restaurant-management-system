
package com.mm.restaurant.application.exceptions;


public class DuplicatedEntryException extends RuntimeException{
    public DuplicatedEntryException (String message){
        super(message);
    }
}
