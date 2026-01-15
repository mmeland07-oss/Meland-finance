package com.meland.finance.controller;

import com.meland.finance.model.Offer;
import com.meland.finance.model.Structure;
import com.meland.finance.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DataService dataService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Structure> structures = dataService.getAllStructures();
        List<Offer> offers = dataService.getAllOffers();

        long totalViews = offers.stream().mapToLong(Offer::getViews).sum();
        long premiumCount = structures.stream().filter(Structure::isPremium).count();

        model.addAttribute("structures", structures);
        model.addAttribute("offers", offers);
        model.addAttribute("totalViews", totalViews);
        model.addAttribute("premiumCount", premiumCount);

        return "admin/dashboard";
    }
}
