package examples.parkinglot;

import java.time.LocalDateTime;

public class Ticket {

    private int ticketID;
    private Vehicle vehicle;
    private ParkingSpace parkingSpace;
    private LocalDateTime issueTime;
    private boolean paymentStatus;

    public Ticket(int ticketID, Vehicle vehicle, ParkingSpace parkingSpace) {
        this.ticketID = ticketID;
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
        this.issueTime = LocalDateTime.now();
        this.paymentStatus = false;
    }

    public int getTicketID() {
        return ticketID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void markPaid() {
        this.paymentStatus = true;
    }

}
