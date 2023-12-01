package GUI;

public class Display {
    //menuLogin
    public void displayMenuLogin(){
        System.out.println("--------------------------------------------------------");
        System.out.println("|                          LOGIN                       |");
        System.out.println("|1. Manger login                                       |");
        System.out.println("|2. Employee login                                     |");
        System.out.println("|3. Exit                                               |");
        System.out.println("--------------------------------------------------------");
    }
    //Menu Manager
    public void displayMenuManager() {
        System.out.println("--------------------------------------------------------");
        System.out.println("|               ASSET MANAGEMENT MANAGER               |");
        System.out.println("|1. Search asset by name                               |");
        System.out.println("|2. Create new asset                                   |");
        System.out.println("|3. Update asset's information                         |");
        System.out.println("|4. Approve the request of employee                    |");
        System.out.println("|5. Show list of borrow asset                          |");
        System.out.println("|6. Quit                                               |");
        System.out.println("--------------------------------------------------------");
    }
    //Menu Employee
    public void displayMenuEmployee() {
        System.out.println("--------------------------------------------------------");
        System.out.println("|               ASSET MANAGEMENT EMPLOYEE              |");
        System.out.println("|1. Search asset by name                               |");
        System.out.println("|2. Show list of borrow asset                          |");
        System.out.println("|3. Quit                                               |");
        System.out.println("--------------------------------------------------------");
    }
    //Login background
    public void displayLogin(){
        System.out.println("--------------------------------------------------------");
        System.out.println("                    LOGIN SYSTEM                        ");
    }
    //Search background
    public void displaySearch(){
        System.out.println("--------------------------------------------------------");
        System.out.println("                    SEARCH ASSET                        ");
    }
    //Create background
    public void displayCreate(){
        System.out.println("--------------------------------------------------------");
        System.out.println("                    CREATE ASSET                        ");
    }
    //Update background
    public void displayUpdate(){
        System.out.println("-------------------------------------------------------");
        System.out.println("                    UPDATE ASSET                       ");
    }
    //Approve background
    public void displayApprove(){
        System.out.println("-------------------------------------------------------");
        System.out.println("                    APPROVE REQUEST                    ");
    }
}
