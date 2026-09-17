import java.util.Scanner;

// Interface
interface Driver {
    void displayDriver();
}

// Abstract class
abstract class Vehicle implements Driver {
    protected String vehicleNumber;
    protected String driverName;

    public Vehicle(String vehicleNumber, String driverName) {
        this.vehicleNumber = vehicleNumber;
        this.driverName = driverName;
    }

    abstract double calculateFare(double distance);

    public void displayDriver() {
        System.out.println("Driver Name: " + driverName);
        System.out.println("Vehicle Number: " + vehicleNumber);
    }
}

// Car class
class Car extends Vehicle {
    public Car(String vehicleNumber, String driverName) {
        super(vehicleNumber, driverName);
    }

    @Override
    double calculateFare(double distance) {
        return 50 + distance * 15;
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleNumber, String driverName) {
        super(vehicleNumber, driverName);
    }

    @Override
    double calculateFare(double distance) {
        return 20 + distance * 8;
    }
}

// Auto class
class Auto extends Vehicle {
    public Auto(String vehicleNumber, String driverName) {
        super(vehicleNumber, driverName);
    }

    @Override
    double calculateFare(double distance) {
        return 30 + distance * 10;
    }
}

// Main class
public class RideSharingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vehicle type (Car/Bike/Auto): ");
        String type = sc.nextLine();

        System.out.print("Enter driver name: ");
        String driverName = sc.nextLine();

        System.out.print("Enter vehicle number: ");
        String vehicleNumber = sc.nextLine();

        System.out.print("Enter travel distance in km: ");
        double distance = sc.nextDouble();

        if (distance <= 0) {
            System.out.println("Invalid distance.");
            sc.close();
            return;
        }

        Vehicle vehicle;

        switch (type.toLowerCase()) {
            case "car":
                vehicle = new Car(vehicleNumber, driverName);
                break;

            case "bike":
                vehicle = new Bike(vehicleNumber, driverName);
                break;

            case "auto":
                vehicle = new Auto(vehicleNumber, driverName);
                break;

            default:
                System.out.println("Invalid vehicle type.");
                sc.close();
                return;
        }

        System.out.println("\n--- RIDE DETAILS ---");
        vehicle.displayDriver();
        System.out.println("Vehicle Type: " + type);
        System.out.println("Distance: " + distance + " km");
        System.out.printf("Total Fare: Rs.%.2f%n",
                vehicle.calculateFare(distance));

        sc.close();
    }
}
