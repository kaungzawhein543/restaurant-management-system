package com.mm.restaurant.application.services;

import com.mm.restaurant.application.dtos.UserDto;
import com.mm.restaurant.application.entities.User;
import com.mm.restaurant.application.utilities.object_mapper.Mappable;
import com.mm.restaurant.application.utilities.object_mapper.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public class CrudService<E extends Mappable, I, D extends Mappable> {

    protected final JpaRepository<E, I> jpaRepository;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    public CrudService(JpaRepository<E, I> jpaRepository, Class<E> entityClass, Class<D> dtoClass) {
        this.jpaRepository = jpaRepository;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }


    public D save(D dto){
        return ObjectMapper.map(jpaRepository.save(ObjectMapper.map(dto, entityClass)), dtoClass);
    }
    public void delete(){

    }
    public void edit(){

    }
    public void read(){

    }

}
