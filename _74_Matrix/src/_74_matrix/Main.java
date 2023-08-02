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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalculatorMatrix cl = new CalculatorMatrix();
        MatrixManagement mana = new MatrixManagement();
        int choice = -1;
        //loop util choice equals 4 
        while (true) {
            //Step1: Display Menu
            mana.displayMenu();
            //Step2: Select option 
            choice = Inputter.selectOption("Your choice: ",1,4);
            //Step3: Perform function base on select option
            switch (choice) {
                //Option1: Addition matrix
                case 1: {
                    mana.displayAddition();
                    int[][] matrix1 = mana.getMatrix1();
                    int[][] matrix2 = mana.getMatrix2(matrix1, "+");
                    int[][] result = cl.additionMatrix(matrix1, matrix2);
                    mana.displayResult(matrix1, matrix2, result, "+");
                    break;
                }
                //Option2: Subtraction matrix
                case 2: {
                    mana.displaySubtraction();
                    int[][] matrix1 = mana.getMatrix1();
                    int[][] matrix2 = mana.getMatrix2(matrix1, "-");
                    int[][] result = cl.subtractionMatrix(matrix1, matrix2);
                    mana.displayResult(matrix1, matrix2, result, "-");
                    break;
                }
                //Option3: Multiplication matrix
                case 3: {
                    mana.displayMultiplication();
                    int[][] matrix1 = mana.getMatrix1();
                    int[][] matrix2 = mana.getMatrix2(matrix1, "*");
                    int[][] result = cl.multiplicationMatrix(matrix1, matrix2);
                    mana.displayResult(matrix1, matrix2, result, "*");
                    break;
                }
                //Option4: Exit program 
                case 4:
                    System.out.println("Exit program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again!");
            }
        }
    }
}
