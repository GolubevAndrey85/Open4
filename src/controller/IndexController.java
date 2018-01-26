package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")
//@RequestMapping("/")
public class IndexController {
@RequestMapping(method = RequestMethod.GET)
    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "index";
    }
    @RequestMapping(method = RequestMethod.POST)
    @GetMapping("/login")
    public String login(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "login";
    }

}
