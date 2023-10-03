public class Car extends Vehicle{
    private String type;
    private String yearOfManufacture;
    public Car() {
    }
    public Car(String id, String name, String color, double price, String brand, String type, String yearOfManufacture) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-30s%-20s%-20f%-20s%-20s%-20s",getId(),getName(),getColor(),getPrice(),getBrand(),getType(),getYearOfManufacture());
    }
}
