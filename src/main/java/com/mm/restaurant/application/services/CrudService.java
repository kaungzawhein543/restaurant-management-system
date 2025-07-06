package com.mm.restaurant.application.services;


import com.mm.restaurant.application.dtos.UserDto;
import com.mm.restaurant.application.exceptions.NoResourceFoundException;
import com.mm.restaurant.application.utilities.object_mapper.Mappable;
import com.mm.restaurant.application.utilities.object_mapper.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public abstract class CrudService<E extends Mappable, I> {

    protected final JpaRepository<E, I> jpaRepository;
    private final Class<E> entityClass;
    private static final NoResourceFoundException NO_RESOURCE_FOUND = new NoResourceFoundException("No resource found");

    public CrudService(final JpaRepository<E, I> jpaRepository,final Class<E> entityClass) {
        this.jpaRepository = jpaRepository;
        this.entityClass = entityClass;
    }

    public <S extends Mappable,D extends Mappable> D save(final S dtoSource,final Class<D> dtoClass){
        return ObjectMapper.map(jpaRepository.save(ObjectMapper.map(dtoSource, entityClass)), dtoClass);
    }

    public void delete(I id){
        jpaRepository.deleteById(id);
    }

    public <S extends Mappable> S update(final I id, final S dtoSource, final Class<S> dtoClass) {

        final E entity = jpaRepository.findById(id).orElseThrow(() -> NO_RESOURCE_FOUND);

        ObjectMapper.map(dtoSource, entity);

        return ObjectMapper.map(jpaRepository.save(entity), dtoClass);

    }

    public <S extends Mappable> S findById(I id, final Class<S> dtoClass){
        return ObjectMapper.map(jpaRepository.findById(id).orElseThrow(() -> NO_RESOURCE_FOUND), dtoClass);
    }

    public <S extends Mappable> List<S> findAll(final Class<S> dtoClass) {
        return ObjectMapper.map(jpaRepository.findAll(), dtoClass);
    }

}
