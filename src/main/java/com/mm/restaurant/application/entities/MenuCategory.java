package com.mm.restaurant.application.entities;


import com.mm.restaurant.application.dtos.MenuCategoryDto;
import com.mm.restaurant.application.utilities.object_mapper.ValidMappable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_menu_category")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ValidMappable(targets = {MenuCategoryDto.class})
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User admin;

}
