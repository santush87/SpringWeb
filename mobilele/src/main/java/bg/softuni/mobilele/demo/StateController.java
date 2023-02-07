package bg.softuni.mobilele.demo;

import bg.softuni.mobilele.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("/demo")
public class StateController extends BaseController {

    private static final String STATE_USERNAME_KEY = "username";

    @GetMapping("/register")
    public ModelAndView getRegister() {
        return super.view("demo/register");
    }

    @PostMapping("/register")
    public ModelAndView postRegister(HttpServletResponse response,
                                     @RequestParam(name = STATE_USERNAME_KEY) String username) {
        final Cookie cookie = new Cookie(STATE_USERNAME_KEY, username);

        response.addCookie(cookie);

        return super.redirect("login");
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return super.view("demo/login");
    }
}
