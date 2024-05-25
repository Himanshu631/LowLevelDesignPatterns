package observerpattern;

public interface WeatherStation {

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
