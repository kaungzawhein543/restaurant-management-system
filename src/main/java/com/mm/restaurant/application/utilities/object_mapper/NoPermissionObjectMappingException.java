
package com.mm.restaurant.application.utilities.object_mapper;

/**
 * NoPermissionObjectMappingException Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

public class NoPermissionObjectMappingException extends RuntimeException {

    public NoPermissionObjectMappingException(Class<? extends Mappable> type, Class<? extends Mappable> sourceType) {
        super(classLinkCreator(type) + " has no permission\n\tto map " + classLinkCreator(sourceType));
    }

    private static String classLinkCreator(Class<?> type) {
        return type.getTypeName().replace("." + type.getSimpleName(), "") + "(" + type.getSimpleName() + ".java:0)";
    }
}
