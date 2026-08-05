package com.spring.country;

public class Country {

    private String countryName;
    private String capital;
    private String currency;

    public String getCountryName() { return countryName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }

    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    @Override
    public String toString() {
        return "Country [countryName=" + countryName + ", capital=" + capital + ", currency=" + currency + "]";
    }
}
