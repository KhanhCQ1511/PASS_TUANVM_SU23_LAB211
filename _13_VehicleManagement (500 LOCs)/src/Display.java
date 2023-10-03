public class Display {
    public void displayMenu(){
        System.out.println("---------- VEHICLE MANAGE ----------");
        System.out.println("| 1. Load data from file           |");
        System.out.println("| 2. Add new vehicle               |");
        System.out.println("| 3. Update vehicle by ID          |");
        System.out.println("| 4. Delete vehicle                |");
        System.out.println("| 5. Search vehicle                |");
        System.out.println("| 6. Show vehicle list             |");
        System.out.println("| 7. Store data to file            |");
        System.out.println("| 8. Quit                          |");
        System.out.println("------------------------------------");
    }
    public void displayLoadData(){

    }
    public void displayAdd(){
        System.out.println("---------- Add new vehicle ----------");
    }
    public void displayUpdate(){
        System.out.println("---------- Update vehicle ----------");
    }
    public void displayDelete(){
        System.out.println("---------- Delete vehicle ----------");
    }
    public void displaySearch(){
        System.out.println("---------- Search vehicle ----------");
    }
    public void displayShow(){
        System.out.println("---------- Show list vehicle ----------");
    }
    public void displaySearchMenu(){
        System.out.println("---------- Search Option ----------");
        System.out.println("1. Search by name");
        System.out.println("2. Search by id");
    }
    public void displayShowMenu(){
        System.out.println("---------- Show Option ----------");
        System.out.println("1. Show all vehicle");
        System.out.println("2. Show all vehicle descending by price");
    }
}
