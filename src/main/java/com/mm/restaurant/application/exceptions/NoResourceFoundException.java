
package com.mm.restaurant.application.exceptions;

/**
 * NoResourceFoundException Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

public class NoResourceFoundException extends RuntimeException{
    public NoResourceFoundException (String message){
        super(message);
    }
}
