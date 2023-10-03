import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Display display = new Display();
        VehicleMangement mn = new VehicleMangement();
        int choice =-1;
        //loop until true
        while (choice!=8){
            //Step 1: Display Menu
            display.displayMenu();
            //Step2: Ask user to select an option
            choice = Inputter.getInputInt("Enter your choice: ");
            //Step3: Do user choice
            switch (choice){
                //3.1: Load data from file
                case 1 ->{
                    if(mn.loadDataFromFile("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_13_VehicleManagement\\src\\File\\Vehicle")){
                        System.out.println("Load successfully!");
                    } else {
                        System.out.println("Can't load file!");
                    }
                    break;
                }
                //3.2: Add new vehicle
                case 2 ->{
                    mn.addVehicle();
                    break;
                }
                //3.3: Update vehicle
                case 3 ->{
                    mn.updateVehicle();
                    break;
                }
                //3.4: Delete vehicle
                case 4 ->{
                    mn.deleteVehicle();
                    break;
                }
                //3.5: Search vehicle
                case 5 ->{
                    mn.searchVehicle();
                    break;
                }
                //3.6: Show vehicle list
                case 6 ->{
                    mn.showListVehicle();
                    break;
                }
                //3.7: Store data to file
                case 7 ->{
                    if(mn.storeDataToFile("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_13_VehicleManagement\\src\\File\\VehicleStore")){
                        System.out.println("Store data successfully!");
                    } else {
                        System.out.println("Can't save file!");
                    }
                    break;
                }
                //3.8: Quit
                case 8 -> {
                    System.out.println("Exit program...");
                    break;
                }
                default -> System.out.println("Invalid choice! Please enter again!");
            }
        }
    }
}

