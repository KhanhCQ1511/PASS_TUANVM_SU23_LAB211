package DTO;

import java.util.Objects;

public class Request extends Asset {
    private String rID;
    private String employeeID;
    private int quantity;
    private String requestDateTime;

    public Request() {
    }

    public Request(String rID, String assetID, String employeeID, int quantity, String requestDateTime) {
        super(assetID);
        this.rID = rID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDateTime = requestDateTime;
    }

    public String getRID() {
        return rID;
    }

    public void setRID(String rID) {
        this.rID = rID;
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

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20d%-20s",getRID(),getAssetID(),getEmployeeID(),getQuantity(),getRequestDateTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(rID, request.rID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rID);
    }
}
