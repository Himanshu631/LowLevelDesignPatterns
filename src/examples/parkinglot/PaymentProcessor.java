package examples.parkinglot;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processPayment(double amt){
        return paymentStrategy.pay(amt);
    }
}
