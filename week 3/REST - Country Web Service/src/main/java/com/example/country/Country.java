package com.example.country;

public class Country {

    private String countryName;
    private String capital;
    private String currency;

    public Country() {}

    public Country(String countryName, String capital, String currency) {
        this.countryName = countryName;
        this.capital = capital;
        this.currency = currency;
    }

    public String getCountryName() { return countryName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }

    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
