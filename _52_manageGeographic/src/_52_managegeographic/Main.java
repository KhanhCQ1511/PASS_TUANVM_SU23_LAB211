/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _52_managegeographic;

import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ManageEastAsiaCountries mn = new ManageEastAsiaCountries();
        int choice = -1;
        //loop until choice equal 5
        while (choice != 5) {
            //Step1: Display menu
            display.displayMenu();
            //Step2: get user's choice
            choice = Integer.parseInt(sc.nextLine());
            try {
                //Step3: Perform function base on the selected option
                switch (choice) {
                    //Option1: Input information of 1 1 country in East Asia
                    case 1:
                        EastAsiaCountries country = new EastAsiaCountries();
                        mn.addCountryInformation(country);
                        break;
                    //Option2: Display information of countries you've just input
                    case 2:
                        EastAsiaCountries recentlyEntered = mn.getRecentlyEnteredInformation();
                        display.displayBanner();
                        recentlyEntered.display();
                        break;
                    //Option3: Search information of countries by user-entered name
                    case 3:
                        String searchName = Inputter.getInputString("Enter name you want to search for: ");
                        EastAsiaCountries[] searchResult = mn.searchInformationByName(searchName);
                        display.displayBanner();
                        //Loop use to access the first to the last element of array searchResult
                        for (EastAsiaCountries countryInfo : searchResult) {
                            countryInfo.display();
                        }
                        break;
                    //Option4: Sort information of countries by name acsending
                    case 4:
                        EastAsiaCountries[] sortedResult = mn.sortInformationByAscendingOrder();
                        display.displayBanner();
                        //Loop use to access the first to the last element of sortResult
                        for (EastAsiaCountries countryInfo : sortedResult) {
                            countryInfo.display();
                        }
                        break;
                    //Option5: Exit program
                    case 5:
                        System.out.println("Exit program...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter again!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
