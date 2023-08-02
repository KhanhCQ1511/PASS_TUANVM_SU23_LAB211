/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _74_matrix;

/**
 *
 * @author khanh
 */
public class MatrixManagement {
    public int[][] getMatrix1() {
        int row = Inputter.getInt("Enter Row Matrix 1:");
        int column = Inputter.getInt("Enter Column Matrix 1:");
        int[][] matrix = new int[row][column];
        //loop use to access first to last element row of matrix
        for (int i = 0; i < row; i++) {
            //loop use to access first to last column of matrix
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Inputter.getMatrix("Enter Matrix1[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
            }
        }
        return matrix;
    }

    public int[][] getMatrix2(int[][] matrix1, String operator) {
        int row, column;
        //loop until true
        while (true) {
            row = Inputter.getInt("Enter Row Matrix 2:");
            // Check operator is + or -
            if (operator.equalsIgnoreCase("+") || operator.equalsIgnoreCase("-")) {
                // Check row of matrix2 equals row of matrix1
                if (row != matrix1.length) {
                    System.out.println("Row of matrix2 must equal row of matrix1");
                    continue;
                }
            } else {
                // Check operator is *
                if (operator.equalsIgnoreCase("*")) {
                    // Check row of matrix2 equals column of matrix1
                    if (row != matrix1[0].length) {
                        System.out.println("Row of matrix2 must equal column of matrix1");
                        continue;
                    }
                }
                break;
            }
        }
        //loop until true
        while (true) {
            column = Inputter.getInt("Enter Column Matrix 2:");
            //Check operator is + - *
            if (operator.equalsIgnoreCase("+") || operator.equalsIgnoreCase("-")) {
                // Check column of matrix2 equals row of matrix1
                if (column != matrix1[0].length) {
                    System.out.println("Column of matrix2 must equal columns of matrix1");
                    continue;
                }
            }
            break;
        }
        int[][] matrix = new int[row][column];
        // Loop to access first to last element row of matrix
        for (int i = 0; i < row; i++) {
            // Loop to access first to last column of matrix
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Inputter.getMatrix("Enter Matrix2[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
            }
        }
        return matrix;
    }

    public void displayAddition() {
        System.out.println("-------- Addition --------");
    }

    public void displaySubtraction() {
        System.out.println("-------- Subtraction --------");
    }

    public void displayMultiplication() {
        System.out.println("-------- Multiplication --------");
    }

    public void displayMatrix(int[][] matrix) {
        //loop use to access  the first to last element row of matrix
        for (int i = 0; i < matrix.length; i++) {
            //loop use to access the first element to last element column of matrix
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, String operator) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println(operator);
        displayMatrix(matrix2);
        System.out.println("=");
        //loop use to access  the first to last element row of matrix
        for (int i = 0; i < result.length; i++) {
            //loop use to access the first element to last element column of matrix
            for (int j = 0; j < result[0].length; j++) {
                System.out.print("[" + result[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void displayMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4.Quit");
    }
}
