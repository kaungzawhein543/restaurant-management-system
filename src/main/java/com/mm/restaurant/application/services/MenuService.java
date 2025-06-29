package com.mm.restaurant.application.services;

import com.mm.restaurant.application.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends CrudService<Menu, Long>{

    public MenuService(JpaRepository<Menu, Long> jpaRepository) {
        super(jpaRepository, Menu.class);
    }
}
