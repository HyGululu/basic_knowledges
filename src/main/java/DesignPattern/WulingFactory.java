package DesignPattern;

public class WulingFactory implements CarFactory1{
    @Override
    public Car1 getCar() {
        return new Wuling1();
    }
}
