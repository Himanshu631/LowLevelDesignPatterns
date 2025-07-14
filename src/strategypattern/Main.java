package strategypattern;

public class Main {
    public static void main(String[] args) {
        DuckContext duckContext = new DuckContext();

        duckContext.setEatBehaviour(new EatNormalBehaviour());
        duckContext.setDisplayBehaviour(new DisplayByTextBehaviour());
        duckContext.setFlyBehaviour(new FlyWingsBehaviour());

        duckContext.executeDisplay();
        duckContext.executeEat();
        duckContext.executeFly();
    }
}
