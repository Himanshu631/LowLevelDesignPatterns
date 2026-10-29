package lld.observerpattern.problem.stock;

import java.util.LinkedHashSet;
import java.util.Set;

public class Stock {
    private String name;
    private double price;

    public Stock(String name, double price) {
        this.price = price;
        this.name = name;
    }

    private final Set<StockObserver> observers = new LinkedHashSet<>();

    public void subscribe(StockObserver stockObserver) {
        observers.add(stockObserver);
    }

    public void unSubscribe(StockObserver stockObserver) {
        observers.remove(stockObserver);
    }

    public void setPrice(double newPrice) {
        if (Double.compare(price, newPrice) == 0) {
            return;
        }

        price = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.onPriceChanged(name, price);
        }
    }


}
