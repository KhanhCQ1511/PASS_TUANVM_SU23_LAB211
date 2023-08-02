/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _65_checkdataformat;

import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class Inputter {
    public static String getInputString(String title){
        while(true){
            System.out.print(title);
            String input = sc.nextLine();
            if(input.isEmpty()){
                System.out.println("Input can't empty");
                continue;
            }
            return input;
        }
    }
    public static double getInputMark(String title, String subject){
        while (true) {            
            System.out.print(title);
            String input = sc.nextLine();
            try{
                if(input.isEmpty()){
                    throw new Exception("Input can't empty");
                }
                double num = Double.parseDouble(input);
                if(num<0){
                    throw new Exception(subject+"is greater than zero");
                }
                if(num>10){
                    throw new Exception(subject+" is les than equal ten");
                }
                return num;
            } catch(NumberFormatException e){
                System.out.println(subject+" is digit");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static String getStudentType(double avgMark){
        if(avgMark<4){
            return "D";
        } else if(avgMark>=4 && avgMark<6){
            return "C";
        } else if(avgMark>=6 && avgMark<=7.5){
            return "B";
        } else {
            return "A";
        }
    }
    public static String getChoiceYesOrNo(String title){
        while (true) {            
            System.out.print(title);
            String input = sc.nextLine();
            if(input.isEmpty()){
                System.out.println("Input can't empty");
                continue;
            }
            if(!input.trim().equalsIgnoreCase("Y") && !input.trim().equalsIgnoreCase("N")){
                System.out.println("Input must be Y or N");
                continue;
            }
            return input;
        }
    }
    private static final Scanner sc = new Scanner(System.in);
}
