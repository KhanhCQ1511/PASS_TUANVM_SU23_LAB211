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
public class display {

    public static void displayMenu() {
        System.out.println("                                MENU                                  ");
        System.out.println("======================================================================");
        System.out.println("1. Input the information ò 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information ò country by user-entered name");
        System.out.println("4. Display the information of countries sorted in ascending order");
        System.out.println("5. Exit");
        System.out.println("======================================================================");
        System.out.print("Enter yout choice: ");
    }

    public static void displayBanner() {
        System.out.printf("%-20s%-20s%-20s%-20s", "ID", "Name", "Total Area", "Terrain");
        System.out.println();
    }

}
