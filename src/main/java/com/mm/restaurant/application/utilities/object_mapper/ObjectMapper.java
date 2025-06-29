
package com.mm.restaurant.application.utilities.object_mapper;

import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * ObjectMapper Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo Zwe Naing Oo
 */
public final class ObjectMapper {

    private ObjectMapper() {}

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static void configure(Consumer<ModelMapper> configure) {
        configure.accept(MODEL_MAPPER);
    }

    public static <S extends Mappable, D extends Mappable> D map(S source, Class<D> destinationType) {
        if (source == null || destinationType == null) return null;
        if(!source.getClass().isAnnotationPresent(ValidMappable.class) || !Arrays.stream(source.getClass().getAnnotation(ValidMappable.class).targets()).toList().contains(destinationType)) throw new NoPermissionObjectMappingException(destinationType, source.getClass());
        return MODEL_MAPPER.map(source, destinationType);
    }

    public static <S extends Mappable, D extends Mappable> List<D> map(List<S> sourceList, Class<D> destinationType) {
        if (sourceList == null || destinationType == null) return Collections.emptyList();
        return sourceList.stream()
                .map(s -> map(s, destinationType))
                .toList();
    }

    public static <S extends Mappable, D extends Mappable> Optional<D> toMappedOptional(S source, Class<D> destinationType) {
        if (source == null || destinationType == null) return Optional.empty();
        return Optional.of(map(source, destinationType));
    }
}