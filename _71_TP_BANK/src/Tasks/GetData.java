/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class GetData {

    public static int inputInteger(String msg, int min, int max) {

        String input;
        int number;
        //loop used to let user enter valid integer number
        do {
            input = inputString(msg);
            if (input.isEmpty()) {
                System.out.println("Input not be empty!");
            } else {
                try {
                    //input= integer
                    number = Integer.parseInt(input);
                    //check number is out of range
                    if (number > max || number < min) {
                        System.out.println("Must in range from " + min + " to " + max + "! try again!");
                        continue;
                    }
                    break;
                } catch (NumberFormatException numex) {
                    System.out.println("Input must be integer! try again!");
                }
            }
        } while (true);
        return number;
    }

    public static String inputString(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        int number;
        //loop used to let user enter valid String Input
        do {
            System.out.print(msg);

            input = sc.nextLine();
            //input !=empty
            if (input.isEmpty()) {
                System.out.println("Input not be empty!");
            } //input not contain commas
            else if (input.contains(", ")) {
                System.out.println("Input not contain commas");
            } else {
                break;
            }
        } while (true);
        return input;
    }

    public static double DoubleInput(String msg, double min, double max) {
        double number;
        String input;
        //loop used to let user enter valid Double Input
        do {
            input = inputString(msg);
            //check format #.0, #.5
            // \\d{1,2} accept 1 or 2 decimal digit
            // [.] dot character
            // [05] accept 1 digits must be 0 or 5
            if (!input.matches("\\d{1,2}[.][05]")) {
                System.out.println("Input must be in format #.0 or #.5 !please enter again");
            } else {
                try {
                    number = Double.parseDouble(input);
                    // check input in range 
                    if (number > max || number < min) {
                        System.out.println("Input must be in range " + min + " and " + max + "!Please enter again");
                        continue;
                    }
                    break;
                } catch (NumberFormatException numex) {
                    System.out.println("Wrong format! Input must be double");
                }
            }

        } while (true);
        return number;
    }

    public static String DateInput() {
        String input;
        Date date;
        //loop used to let user enter valid Date
        do {
            input = inputString("Enter Date: ");
            try {
                SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
                formater.setLenient(false);
                date = formater.parse(input);
                Date now = new Date();
                //check date after present time
                if (date.before(now)) {
                    System.out.println("Date must be the present of past! Try again!");
                    continue;
                }
                break;
            } catch (ParseException e) {
                //print error date in format dd-MM-yyyy "\\d{2}[-]\\d{2}[-]\\d{4}"
                if (!input.matches("\\d{2}[-]\\d{2}[-]\\d{4}")) {
                    System.out.println("Date must in format dd-MM-yyyy! Try Again");

                } 
                //Print error if Date not exist
                else {
                    System.out.println("Date must exist! Try again!");
                }
            }

        } while (true);
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        return formater.format(date);
    }
}
