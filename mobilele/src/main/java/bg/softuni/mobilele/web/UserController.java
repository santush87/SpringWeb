package bg.softuni.mobilele.web;

import bg.softuni.mobilele.domain.dtos.banding.UserLoginFormDto;
import bg.softuni.mobilele.domain.dtos.banding.UserRegisterFormDto;
import bg.softuni.mobilele.domain.dtos.view.UserRoleViewDto;
import bg.softuni.mobilele.services.role.UserRoleService;
import bg.softuni.mobilele.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
@CrossOrigin
public class UserController extends BaseController {
    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
    private final UserRoleService roleService;
//    private final UserService userService;

    @Autowired
    public UserController(UserRoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/register") // post method localhost:8080/users/register
    public String getRegister(Model model) {
        return "auth-register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterForm") UserRegisterFormDto userRegisterInfo,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterForm", userRegisterInfo)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

            return "redirect:register";
        }

//        this.userService.registerUser(userRegisterInfo);

        return "redirect:login";
    }


    @GetMapping("/login")
    public ModelAndView getLogin() {
        return super.view("auth-login");
    }

//    @PostMapping("/login")
//    public ModelAndView postLogin(@Valid @ModelAttribute(name = "userLoginForm") UserLoginFormDto userLoginForm,
//                                  BindingResult bindingResult,
//                                  ModelAndView modelAndView) {
//
//        if (bindingResult.hasErrors()) {
//            return super.view("auth-login",
//                    modelAndView.addObject("userLoginForm", userLoginForm));
//        }
//
//        return super.redirect("/");
//    }

//    @PostMapping("/logout")
//    public ModelAndView postLogout() {
//        this.userService.logout();
//        return super.redirect("/");
//    }

    // Model attributes

    @ModelAttribute(name = "userRegisterForm")
    public UserRegisterFormDto initUserRegisterFormDto() {
        return new UserRegisterFormDto();
    }

    @ModelAttribute(name = "userLoginForm")
    public UserLoginFormDto initUserLoginFormDto() {
        return new UserLoginFormDto();
    }

    @ModelAttribute(name = "roles")
    public List<UserRoleViewDto> getAllRoles() {
        return this.roleService.getAll();
    }
}
