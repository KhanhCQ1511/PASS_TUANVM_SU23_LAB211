/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0006;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws Exception {
        boolean check = true;
        int sizeOrigin = 0;
        //1. Input number of array as positive decimal number
        int sizeOfArray = PositiveDecimalNumber("Enter number of array:");
        //2.Input search value as positive decimal number
        int searchValue = PositiveDecimalNumber("Enter search value:");
        //3. Generate random integer in number range input
//        int arr[] = genArrayByRandom(sizeOfArray);
        check = false;
        int arr[] = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};
//        int arr[] = {1,1,1,1,3,4,6,8,9,9};
        //4.Sorted array by Bubble sort
        BubbleSort(arr);
        //5. Display sorted array
        DisplaySortedArr(arr, 0, arr.length-1);
        //6. perform Binary Search
        int index = performBinarySearch(arr,searchValue,check);
        //7. Display index of search value
        displayIndexOfSearchValue(index, searchValue);
    }
    
    public static int PositiveDecimalNumber(String request)
            throws Exception{
        Scanner sc = new Scanner(System.in);
        String input;
        double number;
        do{
            System.out.println(request);
        //1.Enter input as String
            input = sc.nextLine();
        //2.Check empty of input
            if(input.isEmpty()){
                System.out.println("Input can't be empty!");
                continue;
            }
            try{
                number = Double.parseDouble(input);
        //3.Check negative number
                if(number<0){
                    System.out.println("Input can't be smaller than 0|");
                    continue;
                }
        //4.Check equal to 0
                if(number == 0){
                    System.out.println("Input can't be equal to 0!");
                    continue;
                }
                
        //6.Check real num
                if((int)number != number){
                    System.out.println("Input can't be real number!");
                    continue;
                }
                else{
                    break;
                }
            }
            catch(NumberFormatException exception){
                System.out.println("Input is not number format!");
                continue;
            }
        }while(true);
        return(int)number;
    }
    
    public static int[] genArrayByRandom(int size){
        int a[] = new int[size];
        Random rd = new Random();
        for(int i = 0; i< size; i++){
            a[i]+=rd.nextInt(size);
        }
        return a;
    }
    
    public static void BubbleSort(int arr[]){
        /*Loop access from first to last element in array, after each step, one
        max element is sorted*/
        for(int i  =0; i<arr.length; i++){
        /*Loop access from the first to unsorted element before sorted element*/
            for(int j= 0; j<arr.length-i-1; j++){
        //Compare adjacent element
                if(arr[j]>arr[j+1]){ 
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    public static void DisplaySortedArr(int a[], int left, int right){
        System.out.print("[");
        for(int i = left; i<=right; i++){
            System.out.print(a[i]);
            if(i<right){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }
    
    public static int performBinarySearch(int arr[], int find, boolean check){
        int left = 0; int right = arr.length-1;
        int middle = 0;
        int index = 0;
        int i = 0;
        while(left<=right){
            middle = (left+right)/2;
            i++;
            if(arr[middle] == find){
                if(check == false){
                    System.out.print("Step "+ i+ " (middle element is "+ 
                        arr[middle]+"=="+find+"):");
                    DisplayArr(arr, left, right,find);
                }
                index = middle;
                return index;
            }
            else if(arr[middle] > find){
                if(check == false){
                    System.out.print("Step "+ i+ " (middle element is "+ 
                        arr[middle]+">"+find+"):");
                    DisplayArr(arr, left, right,find);
                }
                right = middle-1;
            }
            else{
                if(check == false){
                    System.out.print("Step "+ i+ " (middle element is "+ 
                        arr[middle]+"<"+find+"):");
                    DisplayArr(arr, left, right,find);
                }
                left = middle+1;
            }
        }
        if(check == false){
            if(index == 0){
                System.out.print("Step "+ (i+1)+ "(searched value absent):");
                DisplayArr(arr, left, right, find);
            }
        }
        return index;
    }
    private static void displayIndexOfSearchValue(int index, int searchValue){
        if(index==0){
            System.out.println("Not found "+searchValue+" in array");
        } else {
            System.out.println("Found "+searchValue+" at index: "+index);
        }   
    }
    
    public static void DisplayArr(int arr[], int left, int right, int searchValue){
        int middle = (left+right)/2;
        System.out.print("[");
        for(int i = 0; i<middle; i++){
            System.out.print(arr[i]);
            if(i<middle){
                System.out.print(", ");
            }
        }
        for(int i=0;i<arr.length;i++){
            if(i==middle){
                System.out.print("("+arr[middle]+")");
                if(i<arr.length-1){
                    System.out.print(", ");
                }
            }
        }
        for(int i=middle+1;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i<arr.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }
}
