package strategypattern;

public class FlyDisableBehaviour implements FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Flying is disabled");
    }
}
