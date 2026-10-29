package lld.observerpattern.problem.stock;

public class PriceAlertService implements StockObserver{

    private final double threshold;

    public PriceAlertService(double threshold) {
        if (!Double.isFinite(threshold) || threshold <= 0) {
            throw new IllegalArgumentException(
                    "Threshold must be finite and positive");
        }
        this.threshold = threshold;
    }

    @Override
    public void onPriceChanged(String symbol, double price) {
        if (price > threshold) {
            System.out.println(
                    "ALERT: " + symbol + " crossed "
                            + formatPrice(threshold));
        }
    }

    private String formatPrice(double price) {
        return price == Math.rint(price)
                ? String.format("%.0f", price)
                : Double.toString(price);
    }
}
