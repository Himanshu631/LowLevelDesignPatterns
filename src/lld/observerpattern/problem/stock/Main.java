package lld.observerpattern.problem.stock;

public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        // Create stocks
        market.createStock("INFY", 1400);
        market.createStock("TCS", 3500);

        // Create observers
        StockObserver mobile = new MobileApp();
        StockObserver alerts = new PriceAlertService(1500);
        StockObserver analytics = new AnalyticsService();

        // Register observers
        market.subscribe("INFY", mobile);
        market.subscribe("INFY", alerts);
        market.subscribe("INFY", analytics);
        market.subscribe("TCS", analytics);

        // Update prices
        market.updatePrice("INFY", 1450);
        market.updatePrice("INFY", 1550);

        // Unsubscribe mobile from INFY only
        market.unsubscribe("INFY", mobile);

        market.updatePrice("INFY", 1600);
        market.updatePrice("TCS", 3550);
    }
}
