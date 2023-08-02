import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        //Loop use to select an option, stop at index 3
        while (choice!=3){
            //Allow user to select an option
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.println("Please choice one option: ");
            choice = Integer.parseInt(sc.nextLine());
            //Select an option
            switch (choice){
                //Step1: Normal calculator
                case 1:{
                    normalCalculator();
                    break;
                }
                //Step2: Calculator BMI index
                case 2:{
                    BMICalculator();
                    break;
                }
                //Exit program
                case 3:{
                    System.out.println("Exit program...");
                }
                default:{
                    System.out.println("Invalid choice, please choose again");
                }
            }
        }
    }
    private static final Scanner sc = new Scanner(System.in);
    //Input number
    private static double inputDoubleNum(){
        while (true){
            String input = sc.nextLine();
            try{
                if (input.isEmpty()){
                    throw new NullPointerException("Input can't empty. Please enter again");
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e){
                System.out.println("Input can't string. Please input number");
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
    }
    //input input operator
    private static String inputOperator(){
        while (true){
            String input = sc.nextLine();
            if (input.isEmpty()){
                System.out.println("Input can't empty. Please enter again");
            } else if (input.equalsIgnoreCase("+") || input.equalsIgnoreCase("-") ||
                        input.equalsIgnoreCase("*") || input.equalsIgnoreCase("/") ||
                        input.equalsIgnoreCase("^") || input.equalsIgnoreCase("=")) {
                return input;
            } else {
                System.out.println("Input must be + - * / ^. Please enter again");
            }
        }
    }
    //Normal Calculate
    private static void normalCalculator(){
        System.out.print("Enter number: ");
        double memory = inputDoubleNum();
        while (true){
            System.out.print("Enter operator: ");
            String operator = inputOperator();
            switch (operator) {
                case "+" -> {
                    System.out.print("Enter number: ");
                    memory += inputDoubleNum();
                    System.out.println("Memory: "+memory);
                }
                case "-" -> {
                    System.out.print("Enter number: ");
                    memory -= inputDoubleNum();
                    System.out.println("Memory: "+memory);
                }
                case "*" -> {
                    System.out.print("Enter number: ");
                    memory *= inputDoubleNum();
                    System.out.println("Memory: "+memory);
                }
                case "/" -> {
                    System.out.print("Enter number: ");
                    double num = 0;
                    while (true) {
                        try {
                            num = inputDoubleNum();
                            if (num == 0) {
                                throw new ArithmeticException("The dividend can't equal zero");
                            } else {
                                break;
                            }
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    memory /= num;
                    System.out.println("Memory: " + memory);
                }
                case "^" -> {
                    double result = Math.pow(memory, inputDoubleNum());
                    System.out.println("Memory: "+result);
                }
                case "=" -> {
                    System.out.println("Result: " + memory);
                    return;
                }
            }
        }
    }
    //Input BMI
    private static double inputBMI(String title){
        while (true){
            System.out.print(title);
            String input = sc.nextLine();
            try{
                if (input.isEmpty()){
                    throw new NullPointerException("Input can't empty. Please enter again!");
                }
                double num = Double.parseDouble(input);
                if (num<0){
                    throw new Exception("Input can't negative number. Please enter again!");
                }
                if (num==0){
                    throw new Exception("Input can't equals zero. Please enter again!");
                }
                return num;
            } catch (NumberFormatException e){
                System.out.println("BMI is digit");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    //Check BMI status
    private static void BMIStatus(String title, double BMI){
        System.out.print(title);
        //Check BMI to print status
        if (BMI<=19){
            System.out.println("Under-standard");
        } else if (BMI>19 && BMI<=25){
            System.out.println("Standard");
        } else if (BMI>25 && BMI<=30){
            System.out.println("Overweight");
        } else if (BMI>30 && BMI<=40) {
            System.out.println("Fat - should lose weight");
        } else if (BMI>40) {
            System.out.println("Very fat - should lose weight immediately");
        }
    }
    //Calculator BMI
    private static void BMICalculator(){
        double weight = inputBMI("Enter weight: ");
        double height = inputBMI("Enter height: ");
        double BMI = weight/((height/100)*(height/100));
        System.out.format("%s%.2f","BMI Number: ",BMI);
        System.out.println();
        BMIStatus("BMI Status: ",BMI);
    }

}
