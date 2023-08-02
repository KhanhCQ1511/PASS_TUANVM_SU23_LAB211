/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _105_product;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class ProductManager {

    public void addStoreKeeper() {
        int storekeeperID = Inputter.getInputInt("Enter storekeeper ID: ");
        boolean idExist = false;
        //loop use to access the first to the last element of listStore
        for (Storekeeper str : listStore) {
            //Check input id is equal id in list
            if (str.getStorekeeperID() == storekeeperID) {
                System.out.println("Storekeeper with code " + storekeeperID + " already exists.");
                idExist = true;
                break;
            }
        }
        //Check id exist
        if (!idExist) {
            String storekeeperName = Inputter.getInputString("Enter storekeeper name: ");
            Storekeeper newStorekeeper = new Storekeeper(storekeeperID, storekeeperName);
            listStore.add(newStorekeeper);
            System.out.println("Add successfully");
        }
        display.displayStorekeeper(listStore);
    }

    public void addProduct() {
        int productID = Inputter.getInputInt("Enter product ID: ");
        boolean idExist = false;
        //loop use to access the first to the last element of listPro
        for (Product pro : listPro) {
            //Check input id is equal id in list
            if (pro.getProductId() == productID) {
                System.out.println("Storekeeper with code " + productID + " already exists.");
                idExist = true;
                break;
            }
        }
        //Check id exist
        if (!idExist) {
            String productName = Inputter.getInputString("Enter product name: ");
            String location = Inputter.getInputString("Enter location of product: ");
            int price = Inputter.getInputInt("Enter price of product: ");
            Date expriDate;
            Date dateOfManufacture;
            //loop until true
            while (true) {
                dateOfManufacture = Inputter.getInputDate("Enter date of manufacture: ");
                expriDate = Inputter.getInputDate("Enter expiry date of product: ");
                //Check dateOfManufacture with expiry date
                if (dateOfManufacture.after(expriDate)) {
                    System.out.println("Date of manufacture must before expiry date");
                    continue;
                } else {
                    break;
                }
            }
            String category = Inputter.getInputString("Enter category of product: ");
            Storekeeper storekeeper = null;
            boolean storekeeperFound = false;
            while (!storekeeperFound) {
                int storekeeperID = Inputter.getInputInt("Enter storekeeper ID: ");
                for (Storekeeper store : listStore) {
                    if (store.getStorekeeperID() == storekeeperID) {
//                        storekeeper = new Storekeeper(store.getStorekeeperID(), store.getStorekeeperName());
                        storekeeper = new Storekeeper(store);
                        storekeeperFound = true;
                        break;
                    }
                }
                if (!storekeeperFound) {
                    System.out.println("Invalid storekeeper ID. Please try again.");
                }
            }
            Date receiptDate;
            //loop ultil true
            while (true) {
                receiptDate = Inputter.getInputDate("Enter receipt date of product: ");
                //Compare receipt date with date of manufacture and expiry date
                if (receiptDate.before(dateOfManufacture) || receiptDate.after(expriDate)) {
                    System.out.println("Receipt date must be between date of manufacture and expiry date");
                    continue;
                } else {
                    break;
                }
            }
            Product newPro = new Product(productID, productName, location, price, expriDate, dateOfManufacture, category, storekeeper, receiptDate);
            listPro.add(newPro);
        }
        display.displayProduct(listPro);
    }

    public void updateProduct() {
        int updateProductID = Inputter.getInputInt("Enter product id want to update: ");
        boolean found = false;
        //loop use to access the first to the last element of listPro
        for (Product pro : listPro) {
            //check updateProductID equals productID in list
            if (pro.getProductId() == updateProductID) {
                String productName = Inputter.getInputString("Enter new product name: ");
                String location = Inputter.getInputString("Enter new location of product: ");
                int price = Inputter.getInputInt("Enter new price of product: ");
                Date expriDate;
                Date dateOfManufacture;
                //loop until true
                while (true) {
                    dateOfManufacture = Inputter.getInputDate("Enter new date of manufacture: ");
                    expriDate = Inputter.getInputDate("Enter new expiry date of product: ");
                    //Check dateOfManufacture after expiry date
                    if (dateOfManufacture.after(expriDate)) {
                        System.out.println("Date of manufacture must before expiry date");
                        continue;
                    } else {
                        break;
                    }
                }
                String category = Inputter.getInputString("Enter new category of product: ");
                Storekeeper storekeeper = null;
                //loop until storekeeper equal null
                while (storekeeper == null) {
                    int storekeeperID = Inputter.getInputInt("Enter new storekeeper ID: ");
                    //loop use to access the first element to the last element of listStore
                    for (Storekeeper store : listStore) {
                        //Check storekeeperID equals storekeeperID in list
                        if (store.getStorekeeperID() == storekeeperID) {
                            store = new Storekeeper(store.getStorekeeperID(), store.getStorekeeperName());
                            break;
                        }
                    }
                }
                Date receiptDate;
                //loop until true
                while (true) {
                    receiptDate = Inputter.getInputDate("Enter new receipt date of product: ");
                    DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                    //Compare receipt date with date of manufacture and expiry date
                    if (receiptDate.before(dateOfManufacture) && receiptDate.after(expriDate)) {
                        System.out.println("Receipt date must be between date of manufacture and expiry date");
                        continue;
                    } else {
                        break;
                    }
                }
                pro.setProductName(productName);
                pro.setLocation(location);
                pro.setPrice(price);
                pro.setExpiryDate(expriDate);
                pro.setDateOfManufature(dateOfManufacture);
                pro.setCategory(category);
                pro.setStorekeeper(storekeeper);
                pro.setReceiptDate(receiptDate);
                System.out.println("Update successfully");
                break;
            }
        }
        //Check found is false
        if (!found) {
            System.out.println("Product not found");
        }
        display.displayProduct(listPro);
    }

    public void searchProduct() {
        int choice = -1;
        //loop until choice equals 5
        while (choice != 5) {
            display.displayMenuSearchProduct();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                //Option1: Search Product by name
                case 1: {
                    String searchName = Inputter.getInputString("Enter product name you want to search: ");
                    //loop use to access the first to the last element of listPro
                    for (int i = 0; i < listPro.size(); i++) {
                        //check searchName equals productName in listPro
                        if (listPro.get(i).getProductName().equalsIgnoreCase(searchName)) {
                            System.out.println(listPro.get(i));
                            return;
                        } else {
                            System.out.println("Not found");
                        }
                    }
                    break;
                }
                ////option2: Search Product by category
                case 2: {
                    String searchCategory = Inputter.getInputString("Enter category of product you want to search: ");
                    //loop use to access the first to the last element of listPro
                    for (int i = 0; i < listPro.size(); i++) {
                        //check searchCategory equals category in list
                        if (listPro.get(i).getCategory().equalsIgnoreCase(searchCategory)) {
                            System.out.println(listPro.get(i));
                            return;
                        } else {
                            System.out.println("Not found");
                        }
                    }
                    break;
                }
                //option3: Search Product by Storekeeper
                case 3: {
                    String searchStorekeeperName = Inputter.getInputString("Enter name storekeeper you want to search: ");
                    //loop use to access the first to the last element of listPro
                    for (int i = 0; i < listPro.size(); i++) {
                        //check StorekeeperName equals storekeeperName in ListPro
                        if (listPro.get(i).getStorekeeper().getStorekeeperName().equalsIgnoreCase(searchStorekeeperName)) {
                            System.out.println(listPro.get(i));
                            return;
                        } else {
                            System.out.println("Not found");
                        }
                    }
                    break;
                }
                //Option4: Search Product by ReceiptDate
                case 4: {
                    Date searchReceiptDate = Inputter.getInputDate("Enter receipt date you want to search: ");
                    //loop use to access the first to the lát element of listPro
                    for (int i = 0; i < listPro.size(); i++) {
                        //Check ReceiptDate in list equals searchReceiptName
                        if (listPro.get(i).getReceiptDate().equals(searchReceiptDate)) {
                            System.out.println(listPro.get(i));
                            return;
                        } else {
                            System.out.println("Not found");
                        }
                    }
                    break;
                }
                //Option5: Exit to main menu
                case 5: {
                    System.out.println("Exit to main menu");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }

    //Sort product by Expiry date, Date of manufacture
    public void sortProduct() {
        int choice = -1;
        while (choice != 3) {
            display.displayMenuSortProduct();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                //option1: Sort by ExpiryDate
                case 1: {
                    //Loop used to access from the first element to the last element of list. After each of these loop end, an element is sorted
                    for (int i = 0; i < listPro.size(); i++) {
                        //Loop used to access from the first unsorted element to the element before the last sorted element.
                        for (int j = 0; j < listPro.size() - i - 1; j++) {
                            //compare two contigious expiryDate
                            if (listPro.get(j).getExpiryDate().after(listPro.get(j + 1).getExpiryDate())) {
                                //swap object if the condition true
                                Product temp = listPro.get(j);
                                listPro.set(j, listPro.get(j + 1));
                                listPro.set(j + 1, temp);
                            }
                        }
                    }
                    display.displayProduct(listPro);
                    break;
                }
                //Option2: Sort by Date of Manufacture
                case 2: {
                    //Loop used to access from the first element to the last element of list. After each of these loop end, an element is sorted
                    for (int i = 0; i < listPro.size(); i++) {
                        //Loop used to access from the first unsorted element to the element before the last sorted element.
                        for (int j = 0; j < listPro.size() - i - 1; j++) {
                            //Compare two contigous dateOfManufacture
                            if (listPro.get(j).getDateOfManufacture().after(listPro.get(j + 1).getDateOfManufacture())) {
                                //swap object if the condition true
                                Product temp = listPro.get(j);
                                listPro.set(j, listPro.get(j + 1));
                                listPro.set(j + 1, temp);
                            }
                        }
                    }
                    display.displayProduct(listPro);
                    break;
                }
                //Option3: Exit to main menu
                case 3: {
                    System.out.println("Exit to main menu");
                    break;
                }
                default: {
                    System.out.println("Invalid choice!");
                }
            }
        }

    }
    private static final Scanner sc = new Scanner(System.in);
    //Create list for storekeeper
    private static final  ArrayList<Storekeeper> listStore = new ArrayList<>();
    //Create list for product
    private static final ArrayList<Product> listPro = new ArrayList<>();
}
