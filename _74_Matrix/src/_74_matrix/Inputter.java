/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _74_matrix;

import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class Inputter {
    private static final Scanner sc = new Scanner(System.in);
    public static int getInt(String title) {
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
                //Check input less than zero and checkRowColumn is true
                if (num < 0) {
                    throw new Exception("Input can't less than zero");
                }
                //check input equal zero and checkRowColumn is true
                if (num == 0) {
                    throw new Exception("Input can't equals zero");
                }
                //Check input is real number
                if (num != (int) num) {
                    throw new Exception("Input can't be a real number");
                }
                return (int) num;
            } catch (NumberFormatException e) {
                    System.out.println("Input can't be a String");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static int getMatrix(String title) {
        Scanner sc = new Scanner(System.in);
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
                //Check input is real number
                if (num != (int) num) {
                    throw new Exception("Input can't be a real number");
                }
                return (int) num;
            } catch (NumberFormatException e) {
                    System.out.println("Value of matrix is digit");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static int selectOption(String title, int min, int max) {
        String input;
        int output;
        do{
            System.out.print(title);
            input=sc.nextLine();
            //If it is empty =>error
            if(input.isEmpty()){
                System.out.println("Input can not be empty! Please enter a positive number");
              //Else input   
            }else{
                //Use try_catch to can catch except format
                try {
                    output = Integer.parseInt(input);
                    //check input in within min and max
                    if(output>=min&&output<=max){
                        break;
                    }else{
                        throw new Exception();
                    }
                } catch (NumberFormatException wrongformat) {
                    System.out.println("Value of matrix is digit");
                }catch(Exception outrange){
                    System.out.println("Input must be in range"+min+"to"+max);
                }
            }
        }
         while(true);
        return output;
    }
}
