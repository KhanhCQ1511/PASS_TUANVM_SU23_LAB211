/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _52_managegeographic;

/**
 *
 * @author khanh
 */
public class Country extends EastAsiaCountries {

    private String countryTerrain;

    public Country() {
    }

    public Country(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-20s%-20s%-20f%-20s",
                getCountryCode(), getCountryName(), getTotalArea(), getCountryTerrain());
        System.out.println();
    }

}
