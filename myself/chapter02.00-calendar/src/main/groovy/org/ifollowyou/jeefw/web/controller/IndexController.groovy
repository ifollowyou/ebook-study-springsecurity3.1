package org.ifollowyou.jeefw.web.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping('/')
class IndexController {

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("name", "wang");
        "aaaindex"
    }

}
