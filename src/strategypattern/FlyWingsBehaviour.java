package strategypattern;

public class FlyWingsBehaviour implements FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Flying by Wings");
    }
}
