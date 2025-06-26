/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.zwel.application.entities;

import com.mm.zwel.application.constants.UserRole;
import com.mm.zwel.application.data_transfer_objects.UserDto;
import com.mm.zwel.application.utilities.object_mapper.Mappable;
import com.mm.zwel.application.utilities.object_mapper.ValidMappable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * UserEntity Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

@Data
@Entity
@Table(name = "tbl_user", uniqueConstraints = {
        @UniqueConstraint(name = User.ukUserUsername, columnNames = "username"),
        @UniqueConstraint(name = User.ukUserEmail, columnNames = "email")
        })
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ValidMappable(targets = {UserDto.class})
public class User implements UserDetails, Mappable {

    public static final String ukUserUsername = "uk_username";
    public static final String ukUserEmail = "uk_email";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private Integer age;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.getRole()));
    }
}
