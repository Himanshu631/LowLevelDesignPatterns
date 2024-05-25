package decoratorpattern;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost(){
        return decoratedcoffee.getCost()+50;
    }

    @Override
    public String getDescription() {
        return decoratedcoffee.getDescription()+", Milk";
    }
}
