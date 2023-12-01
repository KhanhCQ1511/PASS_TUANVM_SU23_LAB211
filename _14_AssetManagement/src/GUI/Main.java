package GUI;

import GUI.AssetManagement;
import GUI.Inputter;

public class Main {
    public static void main(String[] args) {
        AssetManagement mn = new AssetManagement();
        Display display = new Display();
        mn.loadDataFromFile();
        int choice = -1;
        // loop until choice = 3
        while (choice != 3) {
            display.displayMenuLogin();
            choice = Inputter.getInputInt("Enter your choice: ");
            // perform on function
            switch (choice) {
                // Option1: Manager
                case 1 -> {
                    if (mn.loginProgram()){
                        int managerChoice = -1;
                        // loop until managerChoice = 6
                        while (managerChoice != 6) {
                            // Display Menu
                            display.displayMenuManager();
                            managerChoice = Inputter.getInputInt("Enter your choice: ");
                            // Perform on function
                            switch (managerChoice) {
                                // Option1: Search Asset By Name
                                case 1 -> mn.searchAssetByName();
                                // Option2: Create new asset
                                case 2 -> mn.createNewAsset();
                                // Option3: Update asset information
                                case 3 -> mn.updateAssetInfo();
                                // Option4: Approve request of employee
                                case 4 -> mn.approveRequestEmployee();
                                // Option5: Show list of borrow asset
                                case 5 -> mn.showListOfBorrowAsset();
                                // Option6: Exit to log in
                                case 6 -> System.out.println("Log out! Exit to login");
                                default -> System.out.println("Invalid choice! Please enter again!");
                            }
                        }
                    } else {
                        System.out.println();
                    }
                }
                // Option2: Employee
                case 2 -> {
                    int employeeChoice = -1;
                    // loop until employeeChoice = 3
                    while (employeeChoice != 3) {
                        display.displayMenuEmployee();
                        employeeChoice = Inputter.getInputInt("Enter your choice: ");
                        // perform on  function
                        switch (employeeChoice) {
                            // Option1: Search
                            case 1 -> mn.searchAssetByName();
                            // Option2: Show list
                            case 2 -> mn.showListOfBorrowAsset();
                            // Option3: Exit to log in
                            case 3 -> System.out.println("Exit to login!");
                            default -> System.out.println("Invalid choice! Enter again!");
                        }
                    }
                }
                // Option3: Exit program
                case 3 -> System.out.println("Exit program...!");
                default -> System.out.println("Invalid choice! Enter again!");
            }
        }
    }
}
