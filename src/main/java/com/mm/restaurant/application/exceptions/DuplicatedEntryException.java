
package com.mm.restaurant.application.exceptions;

/**
 * DuplicatedEntryException Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

public class DuplicatedEntryException extends RuntimeException{
    public DuplicatedEntryException (String message){
        super(message);
    }
}
