package com.example.country;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {

    private static final Map<String, Country> countries = new HashMap<>();

    static {
        countries.put("IN", new Country("IN", "India", "New Delhi", "INR"));
        countries.put("US", new Country("US", "United States", "Washington D.C.", "USD"));
        countries.put("GB", new Country("GB", "United Kingdom", "London", "GBP"));
        countries.put("JP", new Country("JP", "Japan", "Tokyo", "JPY"));
        countries.put("AU", new Country("AU", "Australia", "Canberra", "AUD"));
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<?> getCountry(@PathVariable String countryCode) {
        Country country = countries.get(countryCode.toUpperCase());
        if (country == null) {
            return ResponseEntity.status(404).body("Country not found for code: " + countryCode);
        }
        return ResponseEntity.ok(country);
    }
}
