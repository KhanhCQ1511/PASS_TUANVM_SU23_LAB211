import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create new list
        ArrayList<Integer> list = new ArrayList<>();
        // 1. Find 45 sequence Fibonacci
//        fibonacci(list, 0, 1, 45);
        generateFibonacci(45, list);
        // 2. Display it
        boolean test = false;
        display(list, 0, test);
    }

//    // 1. Find 45 sequence Fibonacci using recursion
//    private static void fibonacci(ArrayList<Integer> list, int a, int b, int count) {
//        if (count > 0) {
//            list.add(a);
//            fibonacci(list, b, a + b, count - 1);
//        }
//    }

//    private static void fibonacci(int n, ArrayList<Integer> fibonacciList) {
//        for (int i = 0; i < n; i++) {
//            if (i <= 1) {
//                fibonacciList.add((int) i);
//            } else {
//                int fib = fibonacciList.get(i - 1) + fibonacciList.get(i - 2);
//                fibonacciList.add(fib);
//            }
//        }
//    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static void generateFibonacci(int n, ArrayList<Integer> fibonacciList) {
        for (int i = 0; i < n; i++) {
            int fib = fibonacci(i);
            fibonacciList.add(fib);
        }
    }


    //    private static void fibonacci(int n, ArrayList<Integer> fibonacciList){
//
//    }
    private static void display(ArrayList<Integer> list, int index, boolean check) {
        System.out.println("The 45 sequence fibonaô cnayjcci:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            // Check to add comma
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Call the list that assign if test = true
        if (check) {
            if (index < 2) {
                System.out.println("Number " + (index + 1) + " is: " + list.get(index));
            } else {
                int num = list.get(index - 2) + list.get(index - 1);
                System.out.println("Number " + (index + 1) + " is : " + list.get(index - 2) + " + " + list.get(index - 1) + " = " + num);
            }
            if (index < list.size() - 1) {
                display(list, index + 1, check);
            }
        }
    }
}
