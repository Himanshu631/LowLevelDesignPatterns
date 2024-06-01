package examples.parkinglot;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Cash.");
        return true;
    }
}
