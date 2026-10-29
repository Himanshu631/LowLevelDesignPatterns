package lld.observerpattern.problem.stock;

import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private final Map<String, Stock> stocks = new HashMap<>();

    public void createStock(String symbol, double initialPrice) {
        if (stocks.containsKey(symbol)) {
            throw new IllegalArgumentException(
                    "Stock already exists: " + symbol);
        }

        stocks.put(symbol, new Stock(symbol, initialPrice));
    }

    public void subscribe(String symbol, StockObserver observer) {
        getStock(symbol).subscribe(observer);
    }

    public void unsubscribe(String symbol, StockObserver observer) {
        getStock(symbol).unSubscribe(observer);
    }

    public void updatePrice(String symbol, double newPrice) {
        getStock(symbol).setPrice(newPrice);
    }

    private Stock getStock(String symbol) {
        Stock stock = stocks.get(symbol);

        if (stock == null) {
            throw new IllegalArgumentException(
                    "Unknown stock: " + symbol);
        }

        return stock;
    }
}
