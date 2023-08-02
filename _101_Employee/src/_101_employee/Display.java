/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _101_employee;

/**
 *
 * @author khanh
 */
public class Display {
    public static void displayMenu(){
        System.out.println("------ EMPLOYEE ------");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        System.out.println("----------------------");
    }
    public static void displayAdd(){
        System.out.println("----- Add Employee -----");
    }
    public static void displayUpdate(){
        System.out.println("----- Update Employee -----");
    }
    public static void displayRomove(){
        System.out.println("----- Remove Employee -----");
    }
    public static void displaySearch(){
        System.out.println("----- Search Employee -----");
    }
    public static void displaySort(){
        System.out.println("----- Sort Employee -----");
    }
}
