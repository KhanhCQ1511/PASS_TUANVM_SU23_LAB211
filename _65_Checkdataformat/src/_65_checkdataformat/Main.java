/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _65_checkdataformat;

/**
 *
 * @author khanh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentManage stu = new StudentManage();
        //Step 1: input student data
        stu.createStudent();
        //Step2: program classifies student and gives student rank statistic by %
        stu.getPercentTypeStudent();
        //Step3: display
        stu.displayResult();
    }
    
}
