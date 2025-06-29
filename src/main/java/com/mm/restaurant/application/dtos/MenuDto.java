package com.mm.restaurant.application.dtos;

import com.mm.restaurant.application.entities.MenuCategory;
import com.mm.restaurant.application.utilities.object_mapper.Mappable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto implements Mappable {

    private String name;
    private MenuCategory menuCategory;

}
