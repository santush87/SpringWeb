package com.softuni.Pathfinder.web;

import com.softuni.Pathfinder.domain.dtos.models.RoleModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @PatchMapping("/changeUserPermition/{id}")
    @ResponseBody
    public Set<RoleModel> changeRoles(@PathVariable String id,
                                      @RequestParam(defaultValue = "false") Boolean shouldReplaceCurrentRoles,
                                      @RequestBody String roleName){
        return null;
    }


}
