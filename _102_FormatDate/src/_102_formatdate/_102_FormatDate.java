/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _102_formatdate;

import java.io.InputStream;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class _102_FormatDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        //Step1: Enter date with [dd/mm/yyyy] format
        Date date = enterDate("Please enter date with format [dd/MM/yyyy]: ");
        //Step 2: check date exits
        checkInputDate(date);
        //Step 3: determine day of week with input date
        getDayOfWeek(date);
    }
    private static final Scanner sc = new Scanner(System.in);
    //Enter date with format [dd/mm/yyyy]
    private static Date enterDate(String title) throws ParseException{
        //Create format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
    //Check date exits
    private static void checkInputDate(Date date){
        //Create object with format dd/MM/yyy
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        //covert date to String
        String input = formatter.format(date);
        String[] part = input.split("/"); 
        int day = Integer.parseInt(part[0]);
        int month = Integer.parseInt(part[1]);
        int year = Integer.parseInt(part[2]);
        //Check month is valid
        if (month < 1 || month > 12) {
            System.out.println("Invalid month");
            return;
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
            return;
        }
    }
    //determine day of week with input date
    private static void getDayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                System.out.print("Your day is Sunday");
                break;
            case Calendar.MONDAY:
                System.out.print("Your day is Monday");
                break;
            case Calendar.TUESDAY:
                System.out.print("Your day is Tuesday");
                break;
            case Calendar.WEDNESDAY:
                System.out.print("Your day is Wednesday");
                break;
            case Calendar.THURSDAY:
                System.out.print("Your day is Thursday");
                break;
            case Calendar.FRIDAY:
                System.out.print("Your day is Friday");
                break;
            case Calendar.SATURDAY:
                System.out.print("Your day is Saturday");
                break;
            default:
                System.out.print("Invalid");
        }
    }
}
