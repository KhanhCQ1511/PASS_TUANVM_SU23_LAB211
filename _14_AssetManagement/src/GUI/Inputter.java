package GUI;

import java.util.Scanner;
public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    //Input int
    public static int getInputInt(String title){
        String input;
        //loop until true
        while (true){
            System.out.print(title);
            input = sc.nextLine();
            try{
                //check input is empty
                if(input.isEmpty()){
                    throw new Exception("Input can't empty. Please enter again!");
                }
                double num = Double.parseDouble(input);
                //Check input less than zero
                if (num<0){
                    throw new Exception("Input can't less than zero. Please enter again!");
                }
                //Check input is real number
                if (num!=(int)num){
                    throw new Exception("Input can't be a real number. Please enter again!");
                }
                return (int)num;
            } catch (NumberFormatException e){
                System.out.println("Input can't be a String. Please enter again!");
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    //input double
    public static double getInputDouble(String title){
        String input;
        //loop until true
        while (true){
            System.out.print(title);
            input = sc.nextLine();
            try{
                //check input is empty
                if(input.isEmpty()){
                    throw new Exception("Input can't empty. Please enter again!");
                }
                double num = Double.parseDouble(input);
                //Check input less than zero
                if (num<0){
                    throw new Exception("Input can't less than zero. Please enter again!");
                }
                return num;
            } catch (NumberFormatException e){
                System.out.println("Input can't be a String. Please enter again!");
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    //input String
    public static String getInputString(String title,String regex){
        String input;
        //loop until true
        while (true){
            System.out.print(title);
            input = sc.nextLine();
            //Check input is empty
            if(input.isEmpty()){
                System.out.println("Input can't empty! Please enter again!");
                continue;
            } else {
                //Check regex is empty
                if (regex.isEmpty()){
                    break;
                } else if (input.matches(regex)) { //Check input has the same regex format
                    break;
                } else {
                    System.out.println("Input wrong format! Please enter again!");
                    continue;
                }
            }
        }
        return input;
    }
}
