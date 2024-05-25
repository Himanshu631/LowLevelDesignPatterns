package decoratorpattern;

public class Cream extends CoffeeDecorator{

    public Cream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return decoratedcoffee.getCost()+ 80;
    }

    @Override
    public String getDescription() {
        return decoratedcoffee.getDescription() +", Cream";
    }
}
