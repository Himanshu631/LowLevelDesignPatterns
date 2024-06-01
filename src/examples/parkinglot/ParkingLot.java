package examples.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private String name;
    private String location;
    List<ParkingSpace> parkingspaces ;
    private int ticketCounter;

    public ParkingLot(String location, String name) {
        this.parkingspaces = new ArrayList<>();
        this.ticketCounter = 0;
        this.location = location;
        this.name = name;
    }

    public void addParkingSpace(ParkingSpace space){
        parkingspaces.add(space);
    }

    public void removeParkingSpace(ParkingSpace space){
        parkingspaces.remove(space);
    }

    public ParkingSpace getAvailableSpace(VehicleType type) {
        for (ParkingSpace space : parkingspaces) {
            if (!space.isOccupied() && space.getType() == type) {
                return space;
            }
        }
        return null;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        ParkingSpace space = getAvailableSpace(vehicle.getType());
        if (space != null) {
            space.assignVehicle(vehicle);
            Ticket ticket = new Ticket(++ticketCounter, vehicle, space);
            return ticket;
        }
        return null;
    }

    public void releaseSpace(Ticket ticket) {
        ticket.getParkingSpace().removeVehicle();
        ticket.markPaid();
    }

}
