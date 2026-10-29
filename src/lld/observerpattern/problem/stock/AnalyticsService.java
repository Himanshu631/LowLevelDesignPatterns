package lld.observerpattern.problem.stock;

public class AnalyticsService implements StockObserver{

    @Override
    public void onPriceChanged(String name, double price) {
        System.out.println(
                "Analytics recorded: " + name + " = "
                        + formatPrice(price));
    }

    private String formatPrice(double price) {
        return price == Math.rint(price)
                ? String.format("%.0f", price)
                : Double.toString(price);
    }
}
