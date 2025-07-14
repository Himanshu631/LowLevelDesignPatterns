package strategypattern;

public class EatNormalBehaviour implements EatBehaviour{
    @Override
    public void eat() {
        System.out.println("Eat Normally");
    }
}
