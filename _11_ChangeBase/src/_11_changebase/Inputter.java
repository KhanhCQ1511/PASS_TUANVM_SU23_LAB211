/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _11_changebase;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class Inputter {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInputBase(String title) {
        //loop until true
        while (true) {
            System.out.print(title);
            String input = sc.nextLine();
            try {
                //Check input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input can't empty");
                }
                double num = Double.parseDouble(input);
                //Check input less than zero
                if (num < 0) {
                    throw new Exception("Input can't less than zero");
                }
                //Check input equals zero
                if (num == 0) {
                    throw new Exception("Input can't equals zero");
                }
                //Check input is real number
                if (num != (int) num) {
                    throw new Exception("Input can't be a real number");
                }
                //Check input is 1,2,3
                if (num != 1 && num != 2 && num != 3) {
                    throw new Exception("Input base must be 1 or 2 or 3");
                }
                return (int) num;
            } catch (NumberFormatException e) {
                System.out.println("Input can't be a String");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getOutputBase(String title, int inputBase) {
        //Loop until true
        while (true) {
            System.out.print(title);
            String input = sc.nextLine();
            try {
                //Check input is empty
                if (input.isEmpty()) {
                    throw new Exception("Input can't empty");
                }
                double num = Double.parseDouble(input);
                //Check input less than zero
                if (num < 0) {
                    throw new Exception("Input can't less than zero");
                }
                //Check input equals zero
                if (num == 0) {
                    throw new Exception("Input can't equals zero");
                }
                //Check input is real number
                if (num != (int) num) {
                    throw new Exception("Input can't be a real number");
                }
                //Check input is 1,2,3
                if (num != 1 && num != 2 && num != 3) {
                    throw new Exception("Input base must be 1 or 2 or 3");
                }
                //Check num equals input base
                if (num == inputBase) {
                    throw new Exception("Output base can't equals input base");
                }
                return (int) num;
            } catch (NumberFormatException e) {
                System.out.println("Input can't be a String");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static String getInputValue(String title, int inputBase) {
        //loop until true
        while (true) {
            System.out.print(title);
            String input = sc.nextLine();
            String regexInput = "";
            switch (inputBase) {
                //Option1
                case 1:
                    //input is digit is 0 or 1 unlimited length
                    regexInput = "^[0-1]+$";
                    break;
                //option2
                case 2:
                    //input is digit from 0 to 9 unlimited length
                    regexInput = "^[0-9]+$";
                    break;
                //Option3
                case 3:
                    // input is a to z both Uppercase or Lowercase 
                    //and digit from 0 to 9
                    regexInput = "^[a-fA-F0-9]+$";
                    break;
            }
            try {
                //Check input is empty
                if (input.isEmpty()) {
                    throw  new Exception("Input can't empty");
                }
                //Check inputBase is 1,2
                if(inputBase == 1 || inputBase==2){
                     double num = Double.parseDouble(input);
                    //Check input less than zero
                    if (num < 0) {
                        throw new Exception("Input can't less than zero");
                    }
                }
                //Check input format by regexInput
                if(!input.toUpperCase().matches(regexInput)){
                    throw new Exception("Input wrong format");
                }
                return input;
            } catch (NumberFormatException e){
                System.out.println("Input can't be a String");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

        }
    }
}
