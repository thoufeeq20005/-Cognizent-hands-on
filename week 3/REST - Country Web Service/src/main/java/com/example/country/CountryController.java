package com.example.country;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final List<Country> countries = new ArrayList<>(List.of(
        new Country("India", "New Delhi", "INR"),
        new Country("USA", "Washington D.C.", "USD"),
        new Country("France", "Paris", "EUR")
    ));

    @GetMapping
    public List<Country> getAllCountries() {
        return countries;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable String name) {
        return countries.stream()
                .filter(c -> c.getCountryName().equalsIgnoreCase(name))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        countries.add(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(country);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String name) {
        boolean removed = countries.removeIf(c -> c.getCountryName().equalsIgnoreCase(name));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
