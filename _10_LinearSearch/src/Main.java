import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Step1: Input size of array
        int sizeOfArray = checkInputPosDec("Enter number of array:");
        //Step2: Input search value
        int searchValue = checkInputPosDec("Enter search value:");
        //Step3: Generate random array
//        int[] arr = genRanArr(sizeOfArray);
        int[] arr = {2,2,5,2,6,9,9,8,9,8};
        //Step4: Display array
        display("The array: ", arr);
        //Step5: Search value by using linear search
        searchByLinearSearch(arr,searchValue);
    }
    private static final Scanner sc = new Scanner(System.in);
    //Check input positive decimal
    private static int checkInputPosDec(String title){
        while(true){
            System.out.println(title);
            String input = sc.nextLine();
            try{
                if(input.isEmpty()){
                    throw new Exception("Input can't empty");
                }
                double num = Double.parseDouble(input);
                if (num<0){
                    throw new Exception("Input can't negative number");
                }
                if (num==0){
                    throw new Exception("Input can't equals zero");
                }
                if (num != (int) num){
                    throw new Exception("Input can't real number");
                }
                return (int) num;
            } catch (NumberFormatException e){
                System.out.println("Input can't a String");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //Generate random integer for array
    private static int[] genRanArr(int sizeOfArray){
        Random rd = new Random();
        int[] arr = new int[sizeOfArray];
        //Loop use to generate random integer for array
        for (int i=0;i<arr.length;i++){
            arr[i] = rd.nextInt(sizeOfArray);
        }
        return arr;
    }

    //Display array
    private static void display(String title, int[] arr){
        System.out.print(title);
        System.out.print("[");
        //Loop use to access the first element to the lest element of array
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            //Check index less than length of array -1 to add comma
            if (i< arr.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    //Find index of search value by using linear search
    private static void searchByLinearSearch(int[] arr, int searchValue){
        //Loop use to acc the first element to last element of array
        for (int i=0;i<arr.length;i++){
            if(arr[i]==searchValue) {
                System.out.print("Found " + searchValue + " at index: " + i);
                return;
            }
        }
        System.out.print("Not found "+searchValue+" in array");
    }
}