package decoratorpattern;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost(){
        return decoratedcoffee.getCost() + 25;
    }

    @Override
    public String getDescription() {
        return decoratedcoffee.getDescription()+", Sugar";
    }
}
