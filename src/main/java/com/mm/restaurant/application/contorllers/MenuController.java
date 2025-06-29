package com.mm.restaurant.application.contorllers;

import com.mm.restaurant.application.dtos.MenuDto;
import com.mm.restaurant.application.entities.Menu;
import com.mm.restaurant.application.services.MenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/api/v1/menu")
    public void save(@RequestBody MenuDto menu) {
        menuService.save(menu, MenuDto.class);
    }
}
