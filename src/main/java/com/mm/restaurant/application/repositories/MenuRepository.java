package com.mm.restaurant.application.repositories;

import com.mm.restaurant.application.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
