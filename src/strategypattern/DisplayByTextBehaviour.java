package strategypattern;

public class DisplayByTextBehaviour implements DisplayBehaviour{
    @Override
    public void display() {
        System.out.println("Text Display");
    }
}
