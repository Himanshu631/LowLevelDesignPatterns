package practice.parkinglot;

public class DisplayBoard implements ParkingSpaceObserver{
    @Override
    public void update(ParkingSpace parkingSpace) {
        if (parkingSpace.isOccupied()){
            System.out.println("Parking space "+parkingSpace.getId()+" is occupied");
        }
        else {
            System.out.println("Parking space "+parkingSpace.getId()+" is available");
        }
    }
}
