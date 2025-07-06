
package com.mm.restaurant.application.utilities.object_mapper;


public final class NoPermissionObjectMappingException extends RuntimeException {

    public NoPermissionObjectMappingException(final Class<? extends Mappable> type, final Class<? extends Mappable> sourceType) {
        super(classLinkCreator(type) + " has no permission\n\tto map " + classLinkCreator(sourceType));
    }

    public NoPermissionObjectMappingException(final String message){
        super(message);
    }

    private static String classLinkCreator(final Class<?> type) {
        return type.getTypeName().replace("." + type.getSimpleName(), "") + "(" + type.getSimpleName() + ".java:0)";
    }
}
