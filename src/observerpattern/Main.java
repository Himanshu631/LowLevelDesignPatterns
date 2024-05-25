package observerpattern;

public class Main {
    public static void main(String[] args) {
        WeatherStationImpl weatherStation = new WeatherStationImpl();

        ConcreteObserver concreteObserver = new ConcreteObserver(weatherStation);

        weatherStation.setTemperature(44.60f);
        weatherStation.setTemperature(45.56f);
        weatherStation.setTemperature(43.85f);
        weatherStation.setTemperature(40.91f);

    }
}
