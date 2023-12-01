package DTO;

public class Borrow extends Asset {
    private String bID;
    private String employeeID;
    private int quantity;
    private String borrowDateTime;

    public Borrow() {
    }

    public Borrow(String bID,String assetID, String employeeID, int quantity, String borrowDateTime) {
        super(assetID);
        this.bID = bID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.borrowDateTime = borrowDateTime;
    }

    public String getBID() {
        return bID;
    }
    public void setBID(String bID) {
        this.bID = bID;
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getBorrowDateTime() {
        return borrowDateTime;
    }
    public void setBorrowDateTime(String borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20d%-20s",getBID(),getAssetID(),getEmployeeID(),getQuantity(),getBorrowDateTime());
    }
}
