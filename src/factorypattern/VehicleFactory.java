package factorypattern;

public class VehicleFactory {
    public Vehicle createVehicle(String v){
        return switch (v) {
            case "car" -> new Car();
            case "bike" -> new Bike();
            default -> null;
        };
    }
}
