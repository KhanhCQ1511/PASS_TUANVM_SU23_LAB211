import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random rd = new Random();
    private static final Scanner sc = new Scanner(System.in);
        private static int inputNumber(){
            while (true) {
                System.out.println("Enter a number:");
                try {
                    String input = sc.nextLine();
                    if (input.isEmpty()){
                        throw new Exception("Input can't empty. Re-input a positive decimal number");
                    }
                    double n = Double.parseDouble(input);
                    if (n <= 0) {
                        throw new Exception("Input must be a positive number. Re-input a positive decimal number");
                    }
                    if (n != (int) n) {
                        throw new Exception("Input must be a real number. Re-input a positive decimal number");
                    }
                    return (int) n;
                } catch (NumberFormatException e) {
                    System.out.println("Input must be a number. Re-input a positive decimal number");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        private static int[] genRanArr(int num){
            int[] a = new int[num];
            //Loop use to random each element of array
            for(int i=0;i<num;i++){
                a[i]= rd.nextInt(-10,10);
            }
            return a;
        }
    private static void sortArrayByBubbleSort(int[] a, boolean test) {
            //Loop used to access from the first element to the last element of array. After each of these loop end, an element is sorted
        for (int i = 0; i < a.length; i++) {
            //Loop used to access from the first unsorted element to the element before the last sorted element.
            for (int j = 0; j < a.length - i - 1; j++) {
                //Group 2 element in arrays and compare them
                if (a[j] > a[j + 1]) {
                    //Test algorithm
                    if(test=true) {
                        display(a, "");
                        System.out.println("[" + a[j] + "] > [" + a[j + 1] + "], swap");
                    }
                    //swap element if the condition true
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                } else if(test == true) {
                    if (a[j]<a[j+1]){
                        display(a,"");
                        System.out.println("["+a[j]+"] < ["+a[j+1]+"], ok");
                    } else if (a[j]==a[j+1]) {
                        display(a,"");
                        System.out.println("["+a[j]+"] = ["+a[j+1]+"], ok");
                    }
                }
            }
        }
    }
    private static void display(int[] arr,String ptr){
            System.out.print(ptr);
            System.out.print("[");
            //Loop to access each element of array and display
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i]);
                //Check index to display comma
                if (i<arr.length-1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if(ptr == "Unsorted Array: "){
                System.out.println();
            }
    }public static void main(String [] args){
            //Step1:
            int num  = inputNumber();
            //Step2:
//                int[] arr = genRanArr(num);
//                boolean test = false;
        int[] arr = {5,1,12,-5,16};
        boolean test = true;
        //Step3:
        display(arr,"Unsorted array: ");
        //Step4
        sortArrayByBubbleSort(arr,test);
        //Step5:
        display(arr,"Sorted array: ");
    }

}