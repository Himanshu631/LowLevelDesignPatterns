package strategypattern;

public class DuckContext {
    DisplayBehaviour displayBehaviour;
    FlyBehaviour flyBehaviour;
    EatBehaviour eatBehaviour;

    void setDisplayBehaviour(DisplayBehaviour displayBehaviour) {
        this.displayBehaviour = displayBehaviour;
    }

    void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    void setEatBehaviour(EatBehaviour eatBehaviour) {
        this.eatBehaviour = eatBehaviour;
    }

    void executeFly() {
        flyBehaviour.fly();
    }

    void executeEat() {
        eatBehaviour.eat();
    }

    void executeDisplay() {
        displayBehaviour.display();
    }

}
