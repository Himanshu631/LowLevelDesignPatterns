package observerpattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationImpl implements  WeatherStation{

    private List<Observer> observerList;
    private float temperature;

    public WeatherStationImpl() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observerList.remove(o);
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for (Observer obs : observerList){
            obs.update(temperature);
        }
    }

}
