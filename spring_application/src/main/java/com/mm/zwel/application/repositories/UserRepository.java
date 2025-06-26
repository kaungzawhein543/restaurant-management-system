/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.zwel.application.repositories;

import com.mm.zwel.application.entities.User;
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
