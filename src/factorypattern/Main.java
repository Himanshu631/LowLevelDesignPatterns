package factorypattern;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle car = vehicleFactory.createVehicle("car");
        Vehicle bike = vehicleFactory.createVehicle("bike");
        car.drive();
        bike.drive();
    }
}
