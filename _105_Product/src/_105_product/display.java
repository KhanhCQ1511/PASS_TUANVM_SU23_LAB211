/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _105_product;

import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class display {
    public static void displayMenu(){
        System.out.println("-------- PRODUCT MANAGEMENT --------");
        System.out.println("1. Add Storekeeper");
        System.out.println("2. Add product");
        System.out.println("3. Update product");
        System.out.println("4. Search product");
        System.out.println("5. Sort product");
        System.out.println("6. Exit program");
        System.out.print("Enter your choice: ");
    }
    public static void displayStorekeeper(ArrayList<Storekeeper> listStore){
        System.out.println("--------List Storekeeper--------");
        System.out.printf("%-20s%-20s","Storekeeper ID","Storekeeper Name");
        System.out.println();
        //loop use to access the first to the last element of list
        for(Storekeeper store : listStore){
            System.out.println(store);
        }
    }
    public static void displayProduct(ArrayList<Product> listPro){
        System.out.println("--------List Product--------");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-25s%-20s%-20s%-20s%-20s",
                "Product ID","Name","Location","Price","Expiry date","Date of Manufacture","Category","StorekeeperID","StorekeeperName","Receipt Date");
        System.out.println();
        //loop use to access the first to last element of list
        for(Product product : listPro){
            System.out.println(product);
        }
    }
    public static void displayMenuSearchProduct(){
        System.out.println("------ SEARCH PRODUCT ------");
        System.out.println("1. Search product by name");
        System.out.println("2. Search product by category");
        System.out.println("3. Search product by storekeeper");
        System.out.println("4. Search product by receipt date");
        System.out.println("5. Exit to main menu");
        System.out.print("Enter your choice: ");
    }
    public static void displayMenuSortProduct(){
        System.out.println("-------- SORT PRODUCT --------");
        System.out.println("1. Sort product by Expiry date");
        System.out.println("2. Sort product by Date of manufacture");
        System.out.println("3. Exit to main menu");
        System.out.print("Enter your choice: ");
    }
}
