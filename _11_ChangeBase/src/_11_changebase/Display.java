/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _11_changebase;

import java.math.BigInteger;

/**
 *
 * @author khanh
 */
public class Display {
    public static void displayMenu(){
        System.out.println("------Change Base------");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
    }
    
    public static void displayResult(String result){
        System.out.println("  Result of input: "+result);
    }
}
