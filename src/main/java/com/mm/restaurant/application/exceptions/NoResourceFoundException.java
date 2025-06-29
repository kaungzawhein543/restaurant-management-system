
package com.mm.restaurant.application.exceptions;


public class NoResourceFoundException extends RuntimeException{
    public NoResourceFoundException (String message){
        super(message);
    }
}
