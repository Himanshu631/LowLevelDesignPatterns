package strategypattern;

public class FastEatBehaviour implements EatBehaviour{
    @Override
    public void eat() {
        System.out.println("Eat Fast");
    }
}
