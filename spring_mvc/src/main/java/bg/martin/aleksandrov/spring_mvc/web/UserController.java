package bg.martin.aleksandrov.spring_mvc.web;

import bg.martin.aleksandrov.spring_mvc.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String newUser() {
        return "newuser";
    }

    @PostMapping
    public String createUser(UserDTO userDTO) {
        System.out.println("Creating new user... " + userDTO);
        return "usercreated";
    }
}
