public class Motorbike extends Vehicle{
    private double speed;
    private String license;

    public Motorbike() {
    }

    public Motorbike(double speed, String license) {
        this.speed = speed;
        this.license = license;
    }

    public Motorbike(String id, String name, String color, double price, String brand, double speed, String license) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-30s%-20s%-20f%-20s%-20f%-20s",getId(),getName(),getColor(),getPrice(),getBrand(),getSpeed(),getLicense());
    }
}

