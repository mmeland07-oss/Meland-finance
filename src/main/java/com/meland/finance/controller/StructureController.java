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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/structure")
public class StructureController {

    @Autowired
    private DataService dataService;

    // Simulate a logged-in structure (id: s1)
    private final String SIMULATED_STRUCTURE_ID = "s1";

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Structure structure = dataService.getStructureById(SIMULATED_STRUCTURE_ID);
        List<Offer> structureOffers = dataService.getAllOffers().stream()
                .filter(o -> o.getStructureId().equals(SIMULATED_STRUCTURE_ID))
                .collect(Collectors.toList());

        long totalViews = structureOffers.stream().mapToLong(Offer::getViews).sum();

        model.addAttribute("structure", structure);
        model.addAttribute("offers", structureOffers);
        model.addAttribute("totalViews", totalViews);
        model.addAttribute("offerCount", structureOffers.size());

        return "structure/dashboard";
    }

    @GetMapping("/offers/new")
    public String newOffer(Model model) {
        model.addAttribute("offer", new Offer());
        return "structure/edit-offer";
    }
}
