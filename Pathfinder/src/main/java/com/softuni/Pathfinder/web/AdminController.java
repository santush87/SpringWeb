package com.softuni.Pathfinder.web;

import com.softuni.Pathfinder.domain.dtos.binding.RoleChangeForm;
import com.softuni.Pathfinder.domain.enums.RoleName;
import com.softuni.Pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping("/changeUserPermition/{id}")
    @ResponseBody
    public Set<RoleName> changeRoles(@PathVariable Long id,
                                     @RequestParam(defaultValue = "false") Boolean shouldReplaceCurrentRoles,
                                     @RequestBody RoleChangeForm roleName){
        return this.userService.changeUserPermissions(id, shouldReplaceCurrentRoles, roleName);
    }
}
