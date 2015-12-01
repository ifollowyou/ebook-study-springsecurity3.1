package org.ifollowyou.jeefw.web.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexController {

    @RequestMapping('/')
    public String index(Model model) {
        model.addAttribute("name", "wang");
        model.addAttribute("navi", "home");

        "index"
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home/homeSignedIn";
    }
}
