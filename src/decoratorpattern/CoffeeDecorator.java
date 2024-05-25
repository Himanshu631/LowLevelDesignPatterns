package decoratorpattern;

abstract public class CoffeeDecorator implements Coffee{

    protected Coffee decoratedcoffee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedcoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedcoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedcoffee.getDescription();
    }
}
