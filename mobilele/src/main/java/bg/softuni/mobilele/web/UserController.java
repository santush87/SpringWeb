package bg.softuni.mobilele.web;

import bg.softuni.mobilele.domain.dtos.banding.UserRegisterFormDto;
import bg.softuni.mobilele.domain.dtos.view.UserRoleViewDto;
import bg.softuni.mobilele.services.role.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserRoleService roleService;

    @Autowired
    public UserController(UserRoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        List<UserRoleViewDto> roleServiceAll = this.roleService.getAll();

        modelAndView.addObject("roles", roleServiceAll);

        return super.view("auth-register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@ModelAttribute UserRegisterFormDto userRegister) {

        return super.redirect("auth-register");
    }
}
