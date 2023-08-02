/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _101_employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class Inputter {

    private static final Scanner sc = new Scanner(System.in);

    public static String getInputString(String title, String regex) {
        String input;
        //loop until true
        while (true) {
            System.out.print(title);
            input = sc.nextLine();
            //Check input is empty
            if (input.isEmpty()) {
                System.out.println("Input can't empty. Please input again!");
                continue;
            } else {
                //Check regex empty
                if (regex.isEmpty()) {
                    break;
                    //Check input has the same regex format 
                } else if (input.matches(regex)) {
                    break;
                } else {
                    System.out.println("Input wrong format. Please input again!");
                    continue;
                }
            }
        }
        return input;
    }

    public static double getInputDouble(String title) {
        String input;
        //loop until true
        while (true) {
            System.out.print(title);
            input = sc.nextLine();
            try {
                //Check input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input can't empty");
                }
                double num = Double.parseDouble(input);
                //check input less than zero
                if (num < 0) {
                    throw new Exception("Input can't negative number");
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Input can't a String");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Date getInputDate(String title) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        String input;
        //\d{1,2}: the number have 1 or 2 digit number
        //[/]: must contain character /
        //\d{4}: the number must have 4 digit
        String FormatDate = ("\\d{1,2}[/]\\d{1,2}[/]\\d{4}");
        //loop until true
        while (true) {
            System.out.print(title);
            input = sc.nextLine();
            //Check empty
            if (input.isEmpty()) {
                System.out.println("Input can't empty");

            } else {
                //Check if input contain character
                if (!checkConCharacter(input)) {
                    //Check input format
                    if (!input.matches(FormatDate)) {
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
                    try {
                        date = dateFormat.parse(input);
                        Date now = new Date();
                        now = dateFormat.parse(dateFormat.format(now));
                        //Check date with now
                        if(date.after(now)){
                            throw new Exception("Date could be the past!");
                        }
                        break;
                    } catch (ParseException e) {
                        System.out.println("Not valid!");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Input not contain Character!");
                }
            }
        }
        return date;
    }

    private static boolean checkConCharacter(String input) {
        boolean check = true;
        //Loop use to assign variable c to each character of the string
        for (char c : input.toCharArray()) {
            //Check character is digit or '/'
            if (!Character.isDigit(c) && c == '/') {
                check = false;
            }
        }
        return check;
    }
    
    public static int getInputChoice(String title) {
        String input;
        //loop until true
        while (true) {
            System.out.print(title);
            input = sc.nextLine();
            try {
                //Check input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input can't empty");
                }
                double num = Double.parseDouble(input);
                //check input less than zero
                if (num < 0) {
                    throw new Exception("Input can't negative number");
                }
                //Check input equal zero
                if (num == 0) {
                    throw new Exception("Input can't equal zero");
                }
                //Check input is real number
                if((int) num != num){
                    throw new Exception("Input cant't be real number");
                }
                return (int)num;
            } catch (NumberFormatException e) {
                System.out.println("Input can't a String");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
