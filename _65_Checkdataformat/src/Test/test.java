package Test;



import _65_checkdataformat.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Function 1: Input student information
        while (true) {
            System.out.println("Enter student information (or 'exit' to finish):");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Class: ");
            String className = scanner.nextLine();

            System.out.print("Math mark: ");
            double mathMark = Double.parseDouble(scanner.nextLine());

            System.out.print("Physics mark: ");
            double physicsMark = Double.parseDouble(scanner.nextLine());

            System.out.print("Chemistry mark: ");
            double chemistryMark = Double.parseDouble(scanner.nextLine());

            Student student = createStudent(name, className, mathMark, physicsMark, chemistryMark);
            students.add(student);
        }

        // Function 2: Perform classification
        List<Student> classifiedStudents = averageStudent(students);

        // Function 3: Student Type Statistics
        HashMap<String, Double> typeStatistics = getPercentTypeStudent(classifiedStudents);

        // Display results
        displayResults(classifiedStudents, typeStatistics);
    }

    public static Student createStudent(String name, String className, double mathMark, double physicsMark, double chemistryMark) {
        Student student = new Student(name, className, mathMark, physicsMark, chemistryMark);
        return student;
    }

    public static List<Student> averageStudent(List<Student> students) {
        for (Student student : students) {
            double average = (student.getMaths()+ student.getPhysics()+ student.getChemistry()) / 3.0;
            student.setAverage(average);
            if (average > 7.5) {
                student.setType("A");
            } else if (average >= 6 && average <= 7.5) {
                student.setType("B");
            } else if (average >= 4 && average < 6) {
                student.setType("C");
            } else {
                student.setType("D");
            }
        }
        return students;
    }

    public static HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        int totalCount = students.size();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;

        for (Student student : students) {
            String type = student.getType();
            if (type.equals("A")) {
                countA++;
            } else if (type.equals("B")) {
                countB++;
            } else if (type.equals("C")) {
                countC++;
            } else {
                countD++;
            }
        }

        HashMap<String, Double> typeStatistics = new HashMap<>();
        typeStatistics.put("A", (countA * 100.0) / totalCount);
        typeStatistics.put("B", (countB * 100.0) / totalCount);
        typeStatistics.put("C", (countC * 100.0) / totalCount);
        typeStatistics.put("D", (countD * 100.0) / totalCount);

        return typeStatistics;
    }

    public static void displayResults(List<Student> students, HashMap<String, Double> typeStatistics) {
        System.out.println("Student Information:");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("------ Student " + (i + 1) + " Info ------");
            System.out.println("Name: " + student.getName());
            System.out.println("Class: " + student.getClasses());
            System.out.println("Math Mark: " + student.getMaths());
            System.out.println("Physics Mark: " + student.getPhysics());
            System.out.println("Chemistry Mark: " + student.getChemistry());
            System.out.println("Average: " + student.getAverage());
            System.out.println("Type: " + student.getType());
        }

        System.out.println("-------- Classification Info --------");
        for (String type : typeStatistics.keySet()) {
            System.out.println(type + ": " + typeStatistics.get(type) + "%");
        }
    }
}
