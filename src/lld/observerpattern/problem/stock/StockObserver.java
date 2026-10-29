package lld.observerpattern.problem.stock;

public interface StockObserver {
    void onPriceChanged(String name, double price);
}
