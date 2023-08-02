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
public class CalculatorMatrix {
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        //loop use to access the first to the last element row of matrix
        for (int i = 0; i < matrix1.length; i++) {
            //loop use to access the first to the last element column of matrix
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        //loop use to access the first to the last element row of matrix
        for (int i = 0; i < matrix1.length; i++) {
            //loop use to access the first to the last element column of matrix
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        //loop to access the first to the last element of row of matrix 1
        for (int i = 0; i < matrix1.length; i++) {
            //loop to access the first to the last elements of colum matrix 2
            for (int j = 0; j < matrix2[0].length; j++) //loop to access the first to the last elements of row matrix 2
            {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
