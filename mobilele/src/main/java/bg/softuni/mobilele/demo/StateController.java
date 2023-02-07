package bg.softuni.mobilele.demo;

import bg.softuni.mobilele.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class StateController extends BaseController {

    @GetMapping("/register")
    public ModelAndView getRegister(){
        return super.view("demo/register");
    }
}
