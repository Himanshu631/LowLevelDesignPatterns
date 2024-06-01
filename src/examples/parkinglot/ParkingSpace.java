package examples.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {

    private int id;
    private VehicleType vehicleType;
    private boolean isOccupied;
    private Vehicle vehicle;
    private List<ParkingSpaceObserver> observers = new ArrayList<>();

    public ParkingSpace(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

    public void addObserver(ParkingSpaceObserver observer){
        observers.add(observer);
    }

    public void removeObserver(ParkingSpaceObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (ParkingSpaceObserver observer: observers){
            observer.update(this);
        }
    }

    public int getId(){
        return id;
    }

    public VehicleType getType() {
        return vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isOccupied = true;
        notifyObservers();
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.isOccupied = false;
        notifyObservers();
    }
}
