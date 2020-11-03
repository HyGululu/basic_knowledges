package DesignPattern;

public class TaslaFactory implements CarFactory1 {
    @Override
    public Car1 getCar() {
        return new Tsla1();
    }
}
