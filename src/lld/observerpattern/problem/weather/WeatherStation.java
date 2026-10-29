package lld.observerpattern.problem.weather;

public interface WeatherStation {

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
