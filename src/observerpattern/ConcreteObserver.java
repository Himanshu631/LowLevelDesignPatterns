package observerpattern;

public class ConcreteObserver implements Observer{

    private float temperature;

    public ConcreteObserver(WeatherStation w) {
        w.addObserver(this);
    }

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    public void  display(){
        System.out.println("Current temp is "+ temperature);
    }
}
