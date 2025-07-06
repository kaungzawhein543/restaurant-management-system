
package com.mm.restaurant.application.repositories;

import com.mm.restaurant.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
