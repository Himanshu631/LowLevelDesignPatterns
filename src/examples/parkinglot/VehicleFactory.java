package examples.parkinglot;

public class VehicleFactory {
    public static Vehicle createVehicle(String licensePlate, VehicleType vehicleType){
        return new Vehicle(licensePlate,vehicleType);
    }
}
