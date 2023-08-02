/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _52_managegeographic;

import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class Inputter {

    private static final Scanner sc = new Scanner(System.in);

    public static String getInputString(String title) {
        //loop until true
        while (true) {
            System.out.print(title);
            String input = sc.nextLine();
            //check ibnput empty
            if (input.isEmpty()) {
                System.out.println("Input can't empty");
            } else {
                return input;
            }
        }
    }

    public static float getInputFloat(String title) {
        //loop until true
        while (true) {
            System.out.print(title);
            String input = sc.nextLine();
            try {
                //Check input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input can't empty");
                }
                float num = Float.parseFloat(input);
                //Check input less than zero
                if (num < 0) {
                    throw new Exception("Input can't negative number");
                }
                //Check input equals zero
                if (num == 0) {
                    throw new Exception("Input can't equals 0");
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Input can't be a String");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
