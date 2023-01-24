package bg.softuni.mobilele.web;

import bg.softuni.mobilele.services.role.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    private final UserRoleService roleService;

    @Autowired
    public UserController(UserRoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/register")
    public ModelAndView getRegister(){
        return super.view("auth-login");
    }

    @PostMapping("/register")
    public ModelAndView postRegister(){
        return super.redirect("auth-login");
    }
}
