/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparedate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class CompareDate {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        //Step1: User enter the first date with [dd/mm/yyyy]
        Date date1 = enterDateWithFormat("Please enter the first date: ");
        //Step2: User enter the second date with [dd/mm/yyyy]
        Date date2 = enterDateWithFormat("Please enter the second date: ");
        //Step3: Compare and display
        compareAndDisplay(date1, date2);
    }
    private static final Scanner sc = new Scanner(System.in);
    //Input date 
    private static Date enterDateWithFormat(String title) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date date;
        String input;
        //\d{1,2}: the number have 1 or 2 digit number
        //[/]: must contain character /
        //\d{4}: the number must have 4 digit
        String FormatDate = ("\\d{1,2}[/]\\d{1,2}[/]\\d{4}");
        while (true){
            System.out.print(title);
            input = sc.nextLine();
            //Check empty
            if(input.isEmpty()){
                System.out.println("Input can't empty");
             //Check if input contain character
            } else if (!checkConCharacter(input)){
                //Check input format
                if(!input.matches(FormatDate)){
                    System.out.println("Input is wrong format");
                    continue;
                }
                String[] part = input.split("/");
                int day = Integer.parseInt(part[0]);
                int month = Integer.parseInt(part[1]);
                int year = Integer.parseInt(part[2]);
                //Check month is valid
                if (month < 1 || month > 12) {
                    System.out.println("Invalid month");
                    continue;
                }
                //Check leap year
                boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) 
                        || (year % 400 == 0);
                int maxDay;
                //Check month is Feb
                if (month == 2) {
                    // Check if the year is a leap year
                    if (isLeapYear) {
                        maxDay = 29;
                    } else {
                        maxDay = 28;
                    }
                //Check month is 4,6,9,11
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    maxDay = 30;
                } else {
                    maxDay = 31;
                }
                //Check day is valid
                if (day < 1 || day > maxDay) {
                    System.out.println("Invalid day");
                    continue;
                }
                date = dateFormat.parse(input);
                return date;
            } else {
                System.out.println("Input not contain Character!");
            }
        }
        
    }
    //check contains character
    private static boolean checkConCharacter(String input){
        boolean check  = true;
        //Loop use to assign variable c to each character of the string
        for(char c : input.toCharArray()){
            //Check character is digit or '/'
            if(!Character.isDigit(c) && c == '/'){
                check = false;
            }
        }
        return check;
    }
    
    //Compare two date
    private static void compareAndDisplay(Date date1, Date date2){
        System.out.println();
        //Check date1 after date2
        if(date1.after(date2)){
            System.out.print("Date1 is after Date2");
        } else if(date1.before(date2)){ //Check date1 befor date2
            System.out.print("Date1 is before Date2");
        } else { //date1 equals date2
            System.out.print("Date1 is equals Date2");
        }
    }
}