package com.meland.finance.controller;

import com.meland.finance.model.Offer;
import com.meland.finance.model.Structure;
import com.meland.finance.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private DataService dataService;

    @GetMapping
    public String listOffers(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String commune,
            Model model) {

        List<Offer> filteredOffers = dataService.searchOffers(query, type, commune);
        model.addAttribute("offers", filteredOffers);
        model.addAttribute("query", query);
        model.addAttribute("type", type);
        model.addAttribute("commune", commune);

        return "offers";
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable String id, Model model) {
        Offer offer = dataService.getOfferById(id);
        if (offer == null) {
            return "redirect:/offers";
        }

        Structure structure = dataService.getStructureById(offer.getStructureId());
        model.addAttribute("offer", offer);
        model.addAttribute("structure", structure);

        return "offer-details";
    }
}
