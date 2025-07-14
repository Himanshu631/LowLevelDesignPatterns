package practice.parkinglot;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot("Cavisson Parking","Base Parking");

        ParkingSpace carSpace = new ParkingSpace(1, VehicleType.CAR);
        ParkingSpace busSpace = new ParkingSpace(2, VehicleType.BUS);
        ParkingSpace bikeSpace = new ParkingSpace(3, VehicleType.BIKE);
        ParkingSpace truckSpace = new ParkingSpace(4, VehicleType.TRUCK);

        DisplayBoard displayBoard = new DisplayBoard();
        carSpace.addObserver(displayBoard);
        busSpace.addObserver(displayBoard);
        bikeSpace.addObserver(displayBoard);
        truckSpace.addObserver(displayBoard);

        parkingLot.addParkingSpace(carSpace);
        parkingLot.addParkingSpace(busSpace);
        parkingLot.addParkingSpace(bikeSpace);
        parkingLot.addParkingSpace(truckSpace);

        Vehicle car = VehicleFactory.createVehicle("DL052024", VehicleType.CAR);
        Vehicle bike = VehicleFactory.createVehicle("JH057896", VehicleType.BIKE);

        Ticket carTicket = parkingLot.generateTicket(car);
        Ticket bikeTicket = parkingLot.generateTicket(bike);

        System.out.println("Car Ticket ID: " + carTicket.getTicketID());
        System.out.println("Motorcycle Ticket ID: " + bikeTicket.getTicketID());

        PaymentProcessor creditCardPayment = new PaymentProcessor(new CreditCardPaymentStrategy());
        creditCardPayment.processPayment(20.0);

        PaymentProcessor cashPayment = new PaymentProcessor(new CashPaymentStrategy());
        cashPayment.processPayment(10.0);

        parkingLot.releaseSpace(carTicket);
        parkingLot.releaseSpace(bikeTicket);

    }
}
