/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _101_employee;

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
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        int choice = -1;
        //loop until choice equals 6
        while (choice != 6){
            //Step1: Display Menu
            Display.displayMenu();
            //Step2: Select option
            choice = Inputter.getInputChoice("Enter your choice: ");
            switch(choice){
                //Step3: Add employees
                case 1:
                    manager.addEmployees();
                    break;
                //Step4: Update employee
                case 2:
                    manager.updateEmployees();
                    break;
                //Step5: Remove employee
                case 3:
                    manager.removeEmployees();
                    break;
                //Step6: Search Employee
                case 4:
                    manager.searchEmployees();
                    break;
                //Step7: Sort employees by salary
                case 5: 
                    manager.sortEmployeesBySalary();
                    break;
                //Step8: Exit program
                case 6: 
                    System.out.println("Exit program....");
                    break;
                default: System.out.println("Invalid choice! Please enter again!");
            }
        }
    }
   
    
}
