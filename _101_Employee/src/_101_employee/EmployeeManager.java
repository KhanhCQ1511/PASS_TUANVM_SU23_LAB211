/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _101_employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class EmployeeManager {

    public void addEmployees() {
        Display.displayAdd();
        String id = Inputter.getInputString("Enter id of employee: ", "");
        boolean idExist = false;
        //loop use to access the first to the last element of list
        for (Employee employee : list) {
            //Check input id is equal id in list
            if (employee.getId().equalsIgnoreCase(id)) {
                System.out.println("Employee with id " + id + " already exists.");
                idExist = true;
                break;
            }
        }
        //check idExits is not false;
        if (!idExist) {
            String firstName = Inputter.getInputString("Enter first name of employee: ", "");
            String lastName = Inputter.getInputString("Enter lastName of employee: ", "");
            //^0: 0 must be the first digit of number
            //\\d{9}: String must be 9 number
            String phone = Inputter.getInputString("Enter phone number of employee (10 number and 0 is first digit): ", "^0\\d{9}$");
            //[a-zA-Z0-9._]: Any alphanumeric character, period (.) or underscore (_) that appears one or more times.
            //@: must be has @
            //[a-zA-z.]: Any alphanumeric character appears one or more time
            //\\.(com|vn): must have Dot (.) and string "com" or "vn" in last.
            String email = Inputter.getInputString("Enter email of employee (example@example.(com|vn)): ",
                    "^[a-zA-Z0-9._]+@[a-zA-Z.]+\\.(com|vn)$");
            String address = Inputter.getInputString("Enter address of emloyee: ", "");
            //\d{1,2}: the number have 1 or 2 digit number
            //[/]: must contain character /
            //\d{4}: the number must have 4 digit
            Date DOB = Inputter.getInputDate("Enter date of birth of employee: ");
            //(men|woman|Men|Women): input must be men or women or Men or Women
            String sex = Inputter.getInputString("Enter sex of employee (Men or Women): ", "^(men|women|Men|Women)$");
            double salary = Inputter.getInputDouble("Enter salary of employee: ");
            String agency = Inputter.getInputString("Enter agency of employee: ", "");
            Employee newEmployee = new Employee(id, firstName, lastName, phone, email, address, DOB, sex, salary, agency);
            list.add(newEmployee);
            System.out.println("Add employee successfully");
            System.out.println();
        }
        System.out.println("------ List of employee -------");
        System.out.printf("%-10s%-15s%-15s%-20s%-30s%-15s%-20s%-10s%-15s%-10s",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        System.out.println();
        //loop use to access the first to the last element of list
        for (Employee em : list) {
            System.out.println(em);
        }
    }

    public void updateEmployees() {
        Display.displayUpdate();
        String updateId = Inputter.getInputString("Enter employee id you want to update: ", "");
        boolean found = false;
        //loop use to access the first to the last element of list
        for (Employee em : list) {
            // Check update id equals id in list
            if (em.getId().equalsIgnoreCase(updateId)) {
                found = true;
                String newID = Inputter.getInputString("Enter new id of employee: ", "");
                // Check if newID matches the id of any other employee in the list
                if (!em.getId().equalsIgnoreCase(newID)) {
                    boolean idExist = false;
                    //loop use to access the first to the last element of list
                    for (Employee employee : list) {
                        if (employee.getId().equalsIgnoreCase(newID)) {
                            System.out.println("Employee with new id " + newID + " already exists.");
                            idExist = true;
                            break;
                        }
                    }
                    //Check idExist
                    if (idExist) {
                        continue;
                    }
                }
                //^(Y|N)$: must be input Y or N 
                String confirmUpdate = Inputter.getInputString("Do you want to update information (Y/N): ", "^(Y|N)$");
                //Check confirmUpdate equal Y
                if (confirmUpdate.equalsIgnoreCase("Y")) {
                    String newFirstName = Inputter.getInputString("Enter new first name of employee: ", "");
                    String newLastName = Inputter.getInputString("Enter new last name of employee: ", "");
                    //^0: 0 must be the first number
                    //d{9}: must be have 9 digit 
                    String newPhone = Inputter.getInputString("Enter new phone number of employee (10 number and 0 is first digit): ", "^0\\d{9}$");
                    //[a-zA-Z0-9._]: must be character a-z, A-Z, 0-9, . ,_ appear one or more time
                    //@[a-zA-Z.]: must be have @, and after is character in a-z,A-Z,. appear one or more time
                    //\.(com|vn): .com or .vn must be appear in last of String
                    String newEmail = Inputter.getInputString("Enter new email of employee (example@example.(com|vn)): ",
                            "^[a-zA-Z0-9._]+@[a-zA-Z.]+\\.(com|vn)$");
                    String newAddress = Inputter.getInputString("Enter new address of employee: ", "");
                    Date newDOB = Inputter.getInputDate("Enter new date of birth of employee: ");
                    //^(men | women | Men | Women): must be men or women or Men or Women
                    String newSex = Inputter.getInputString("Enter new sex of employee (Men or Women): ", "^(men|women|Men|Women)$");
                    double newSalary = Inputter.getInputDouble("Enter new salary of employee: ");
                    String newAgency = Inputter.getInputString("Enter new agency of employee: ", "");
                    em.setFirstName(newFirstName);
                    em.setLastName(newLastName);
                    em.setPhone(newPhone);
                    em.setEmail(newEmail);
                    em.setAddress(newAddress);
                    em.setDOB(newDOB);
                    em.setSex(newSex);
                    em.setSalary(newSalary);
                    em.setAgency(newAgency);
                }
                em.setId(newID);
                System.out.println("Update successful!");
                break;
            }
        }
        //Check found is false
        if (!found) {
            System.out.println("Employee not found");
        }
        System.out.println("------ List of employees -------");
        System.out.printf("%-10s%-15s%-15s%-20s%-30s%-15s%-20s%-10s%-15s%-10s%n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        //loop use to access the first to the last element of list
        for (Employee em : list) {
            System.out.println(em);
        }
    }

    public void removeEmployees() {
        Display.displayRomove();
        String removeId = Inputter.getInputString("Enter employee id you want to remove: ", "");
        boolean found = false;
        //loop use to access the first to the last element of list
        for (Employee em : list) {
            // Check remove id equal id in list
            if (em.getId().equalsIgnoreCase(removeId)) {
                list.remove(em);
                System.out.println("Employee removed successfully");
                found = true;
                break;
            }
        }
        //Check found is false
        if (!found) {
            System.out.println("Employee not found");
        }
        System.out.println("------ List of employees -------");
        System.out.printf("%-10s%-15s%-15s%-20s%-30s%-15s%-20s%-10s%-15s%-10s%n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        //loop use to access the first to the last element of list
        for (Employee em : list) {
            System.out.println(em);
        }
    }

    public void searchEmployees() {
        Display.displaySearch();
        String searchName = Inputter.getInputString("Enter employee name want to search: ", "").trim();
        ArrayList<Employee> listSearch = new ArrayList<>();
        //loop use to access the first to the last element of list
        for (Employee employee : list) {
            String fullName = employee.getFirstName() + " " + employee.getLastName();
            //if full name have contains in search name
            if (fullName.toUpperCase().contains(searchName.toUpperCase())) {
                listSearch.add(employee);
            }
        }
        //Check listSearch is empty
        if (listSearch.isEmpty()) {
            System.out.println("Employee not found");
        } else {
            System.out.printf("%-10s%-15s%-15s%-20s%-30s%-15s%-20s%-10s%-15s%-10s",
                    "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
            System.out.println("");
            //loop use to access the first elemt to the last element of listSearch
            for (Employee employee : listSearch) {
                System.out.println(employee);
            }
        }
    }

    public void sortEmployeesBySalary() {
        Display.displaySort();
        //Loop used to access from the first element to the last element of list. After each of these loop end, an element is sorted
        for (int i = 0; i < list.size(); i++) {
            //Loop used to access from the first unsorted element to the element before the last sorted element.
            for (int j = 0; j < list.size() - i - 1; j++) {
                //compare two contigiuos salary
                if (list.get(j).getSalary() > list.get(j + 1).getSalary()) {
                    Employee temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        System.out.println("------ List of employee -------");
        System.out.printf("%-10s%-15s%-15s%-20s%-30s%-15s%-20s%-10s%-15s%-10s",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        System.out.println();
        //loop use to access the first to the last element of list
        for (Employee em : list) {
            System.out.println(em);
        }
    }

    private static final ArrayList<Employee> list = new ArrayList<Employee>();
    private static final Scanner sc = new Scanner(System.in);
}
