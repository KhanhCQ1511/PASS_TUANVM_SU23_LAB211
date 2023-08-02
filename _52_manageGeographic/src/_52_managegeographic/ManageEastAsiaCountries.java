/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _52_managegeographic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class ManageEastAsiaCountries {

    public void addCountryInformation(EastAsiaCountries country) {
        String countryCode = Inputter.getInputString("Enter code of country: ");
        boolean codeExist = false;
        //loop use to access the first to the last element of list
        for (EastAsiaCountries ea : list) {
            //Check countryCode equals countryCode in list
            if (ea.getCountryCode().equalsIgnoreCase(countryCode)) {
                System.out.println("Country with code " + countryCode + " already exists.");
                codeExist = true;
                break;
            }
        }
        //check codeExist is false
        if (!codeExist) {
            String countryName = Inputter.getInputString("Enter name of country: ");
            float totalArea = Inputter.getInputFloat("Enter total Area: ");
            String countryTerrain = Inputter.getInputString("Enter terrain of country: ");
            Country newCountry = new Country(countryTerrain, countryCode, countryName, totalArea);
            list.add(newCountry);
            System.out.println("Add sucessfully!");
        }

    }

    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        //Check list is empty
        if (list.isEmpty()) {
            throw new Exception("No countries in list");
        } else {
            return list.get(list.size() - 1);
        }

    }

    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        List<EastAsiaCountries> result = new ArrayList<>();
        // Loop is used to iterate over the list of EastAsiaCountries object
        for (EastAsiaCountries country : list) {
            //check country name in list equal name input
            if (country.getCountryName().equalsIgnoreCase(name)) {
                result.add(country);
            }
        }
        //check list is empty
        if (result.isEmpty()) {
            throw new Exception("Country not found");
        }
        return result.toArray(new EastAsiaCountries[0]);
    }

    //Sort information of countries by name
    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        //Check list is empty
        if (list.isEmpty()) {
            throw new Exception("No countries in list");
        }
        //Loop used to access from the first element to the last element of list. After each of these loop end, an element is sorted
        for (int i = 0; i < list.size(); i++) {
            //Loop used to access from the first unsorted element to the element before the last sorted element.
            for (int j = 0; j < list.size() - i - 1; j++) {
                //Compares two country names
                if (list.get(j).getCountryName().compareToIgnoreCase(list.get(j + 1).getCountryName()) > 0) {
                    //swap object if the condition true
                    Country temp = (Country) list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list.toArray(new EastAsiaCountries[0]);
    }
    private static final Scanner sc = new Scanner(System.in);
    //Create array list
    private static final ArrayList<Country> list = new ArrayList();
}
