
package com.mm.restaurant.application.repositories;

import com.mm.restaurant.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
