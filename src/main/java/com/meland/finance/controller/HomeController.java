package com.meland.finance.controller;

import com.meland.finance.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("offers", dataService.getAllOffers());
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contactEmail", "mmeland07@gmail.com");
        return "contact";
    }
}
