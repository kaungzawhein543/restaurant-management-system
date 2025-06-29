package com.mm.restaurant.application.entities;

import com.mm.restaurant.application.constants.MenuStatus;
import com.mm.restaurant.application.dtos.MenuDto;
import com.mm.restaurant.application.utilities.object_mapper.Mappable;
import com.mm.restaurant.application.utilities.object_mapper.ValidMappable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_menu")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ValidMappable(targets = {MenuDto.class})
public class Menu implements Mappable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(nullable = false)
    private MenuCategory menuCategory;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MenuStatus isActive;


}
