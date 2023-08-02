/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _11_changebase;

/**
 *
 * @author khanh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Convert cv = new Convert();
        // TODO code application logic here
        //loop until true
        while (true) {
            Display.displayMenu();
            //Step1: Choose the base number input
            int inputBase = Inputter.getInputBase("Choose the base number input: ");
            //Step2: Choose the base number output
            int outputBase = Inputter.getOutputBase("Choose the base number output: ", inputBase);
            //Step3: Enter the input value
            String inputValue = Inputter.getInputValue("Enter input value: ",inputBase);
            //Step4: Program convert process
            String result = cv.convertValue(inputBase, outputBase, inputValue);
            //Step5: Print output value
            Display.displayResult(result);
        }
    }

}
