package com.meland.finance.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meland.finance.model.Offer;
import com.meland.finance.model.Structure;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Offer> offers = new ArrayList<>();
    private List<Structure> structures = new ArrayList<>();

    @Value("classpath:data/offers.json")
    private Resource offersResource;

    @Value("classpath:data/structures.json")
    private Resource structuresResource;

    @PostConstruct
    public void init() throws IOException {
        loadData();
    }

    public synchronized void loadData() throws IOException {
        if (offersResource.exists()) {
            offers = objectMapper.readValue(offersResource.getInputStream(), new TypeReference<List<Offer>>() {
            });
        }
        if (structuresResource.exists()) {
            structures = objectMapper.readValue(structuresResource.getInputStream(),
                    new TypeReference<List<Structure>>() {
                    });
        }
    }

    // Offers
    public List<Offer> getAllOffers() {
        return offers;
    }

    public Offer getOfferById(String id) {
        return offers.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }

    public void addOffer(Offer offer) {
        offers.add(offer);
        // In a real app with file persistence, we would write back to the JSON file
        // here.
        // For this demo, memory-only updates work, or we can implement file write
        // logic.
    }

    // Structures
    public List<Structure> getAllStructures() {
        return structures;
    }

    public Structure getStructureById(String id) {
        return structures.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    // Search and Filters
    public List<Offer> searchOffers(String query, String type, String commune) {
        return offers.stream()
                .filter(o -> (query == null || query.isEmpty()
                        || o.getTitle().toLowerCase().contains(query.toLowerCase())))
                .filter(o -> (type == null || type.equals("Touts") || type.isEmpty()
                        || o.getType().equalsIgnoreCase(type)))
                .filter(o -> (commune == null || commune.equals("Toutes les communes") || commune.isEmpty()
                        || o.getCommune().equalsIgnoreCase(commune)))
                .collect(Collectors.toList());
    }
}
