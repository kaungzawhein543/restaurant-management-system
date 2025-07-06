package com.mm.restaurant.application.utilities.object_mapper;

import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public final class ObjectMapper {

    private ObjectMapper() {}

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private static final NullPointerException SOURCE_NULL_POINTER_EXCEPTION = new NullPointerException("Source cannot be null.");

    private static final NullPointerException DESTINATION_NULL_POINTER_EXCEPTION = new NullPointerException("Destination cannot be null.");

    private static final NoPermissionObjectMappingException LIST_SIZE_NOT_MATCH_EXCEPTION = new NoPermissionObjectMappingException("Source list and destination list sizes are not match to map.");

    public static void configure(final Consumer<ModelMapper> configure) {
        configure.accept(MODEL_MAPPER);
    }

    public static <S extends Mappable, D extends Mappable> D map(final S source, final Class<D> destinationType) {
        if (source == null || destinationType == null) return null;
        if (!source.getClass().isAnnotationPresent(ValidMappable.class) || !Arrays.stream(source.getClass().getAnnotation(ValidMappable.class).targets()).toList().contains(destinationType))
            throw new NoPermissionObjectMappingException(destinationType, source.getClass());
        return MODEL_MAPPER.map(source, destinationType);
    }

    public static <S extends Mappable, D extends Mappable> List<D> map(final List<S> sourceList, final Class<D> destinationType) {
        if (sourceList == null) {
            throw SOURCE_NULL_POINTER_EXCEPTION;
        }
        if (destinationType == null) {
            throw DESTINATION_NULL_POINTER_EXCEPTION;
        }
        if (sourceList.isEmpty()) return Collections.emptyList();
        return sourceList.stream()
                .map(s -> map(s, destinationType))
                .toList();
    }

    public static <S extends Mappable, D extends Mappable> void map(final S source, final D destination) {
        if (source == null) {
            throw SOURCE_NULL_POINTER_EXCEPTION;
        }
        if (destination == null) {
            throw DESTINATION_NULL_POINTER_EXCEPTION;
        }
        if (!source.getClass().isAnnotationPresent(ValidMappable.class) || !Arrays.stream(source.getClass().getAnnotation(ValidMappable.class).targets()).toList().contains(destination.getClass()))
            throw new NoPermissionObjectMappingException(destination.getClass(), source.getClass());
        MODEL_MAPPER.map(source, destination);
    }

    public static <S extends Mappable, D extends Mappable> void map(final List<S> sourceList, final List<D> destinationList){
        if (sourceList == null) {
            throw SOURCE_NULL_POINTER_EXCEPTION;
        }
        if (destinationList == null) {
            throw DESTINATION_NULL_POINTER_EXCEPTION;
        }
        if(sourceList.size() != destinationList.size()) throw LIST_SIZE_NOT_MATCH_EXCEPTION;

        for (int i = 0; i < sourceList.size(); i++) {
            map(sourceList.get(i), destinationList.get(i));
        }
    }

    public static <S extends Mappable, D extends Mappable> Optional<D> toMappedOptional(final S source, final Class<D> destinationType) {
        if (source == null || destinationType == null) return Optional.empty();
        return Optional.of(map(source, destinationType));
    }
}