/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _105_product;

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
        ProductManager pm = new ProductManager();
        int choice = -1;
        //loop until choice equals 6
        while (choice != 6) {
            //Step1: Display Menu
            display.displayMenu();
            //Step2: Select option
            choice = Integer.parseInt(sc.nextLine());
            //Step3: Do option select
            switch (choice) {
                //Option1: Add Storekeeper
                case 1:
                    pm.addStoreKeeper();
                    break;
                //Option2: Add product
                case 2:
                    pm.addProduct();
                    break;
                //Option3: Update product
                case 3:
                    pm.updateProduct();
                    break;
                //Option4: Search product by Name, Category, Storekeeper, ReceiptDate
                case 4:
                    pm.searchProduct();
                    break;
                //Option5: Sort product by Expiry date, Date of Manufacture
                case 5:
                    pm.sortProduct();
                    break;
                //Option6: Exit program
                case 6:
                    System.out.println("Exit program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again!");
            }
        }
    }

}
