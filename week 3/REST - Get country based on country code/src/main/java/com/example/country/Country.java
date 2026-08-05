package com.example.country;

public class Country {
    private String countryCode;
    private String countryName;
    private String capital;
    private String currency;

    public Country(String countryCode, String countryName, String capital, String currency) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.capital = capital;
        this.currency = currency;
    }

    public String getCountryCode() { return countryCode; }
    public String getCountryName() { return countryName; }
    public String getCapital() { return capital; }
    public String getCurrency() { return currency; }
}
