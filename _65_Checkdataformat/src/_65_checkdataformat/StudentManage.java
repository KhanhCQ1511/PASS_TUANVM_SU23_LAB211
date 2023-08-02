/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _65_checkdataformat;

import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class StudentManage {

    public void createStudent() {
        while (true) {
            String name = Inputter.getInputString("Name:");
            String classes = Inputter.getInputString("Classes:");
            double maths = Inputter.getInputMark("Maths:", "Maths");
            double chemistry = Inputter.getInputMark("Chemistry:", "Chemistry");
            double physics = Inputter.getInputMark("Physics:", "Physics");
            double average = (maths + chemistry + physics) / 3;
            String type = Inputter.getStudentType(average);
            Student newStu = new Student(name, classes, maths, chemistry, physics, average, type);
            list.add(newStu);
            String confirm = Inputter.getChoiceYesOrNo("Do you want to enter more student information?(Y/N):");
            if (confirm.equalsIgnoreCase("N".trim())) {
                return;
            }
        }

    }

    public void getPercentTypeStudent() {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType().trim().equals("A".trim())) {
                countA++;
            }else
            if (list.get(i).getType().trim().equals("B".trim())) {
                countB++;
            } else
            if (list.get(i).getType().trim().equals("C".trim())) {
                countC++;
            } else
            if (list.get(i).getType().trim().equals("D".trim())) {
                countD++;
            }
        }
        int totalCount = list.size();
        double percentA = (countA * 100.0) / totalCount;
        double percentB = (countB * 100.0) / totalCount;
        double percentC = (countC * 100.0) / totalCount;
        double percentD = (countD * 100.0) / totalCount;
        listType.add(percentA);
        listType.add(percentB);
        listType.add(percentC);
        listType.add(percentD);
    }

    public void displayResult() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("------ Student" + (i+1) + " Info ------");
            System.out.println("Name:" + list.get(i).getName());
            System.out.println("Classes:" + list.get(i).getClasses());
            System.out.println("AVG:" + list.get(i).getAverage());
            System.out.println("Type:" + list.get(i).getType());
        }
        System.out.println("--------Classification Info --------");
        System.out.printf("A: %.1f%%\n", listType.get(0));
        System.out.printf("B: %.1f%%\n", listType.get(1));
        System.out.printf("C: %.1f%%\n", listType.get(2));
        System.out.printf("D: %.1f%%\n", listType.get(3));
    }
    private final ArrayList<Student> list = new ArrayList<>();
    private final ArrayList<Double> listType = new ArrayList<>();
}
