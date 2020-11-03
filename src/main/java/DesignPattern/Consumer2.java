package DesignPattern;

/**
 * 工厂模式-工厂方法模式
 */
public class Consumer2 {
    public static void main(String[] args) {
        //原始方法，了解接口，了解实现类
        Car1 car = new WulingFactory().getCar();
        Car1 car2 = new TaslaFactory().getCar();



        car.name();
        car2.name();
    }
}

interface Car1{
    void name();
}

class Wuling1 implements Car1 {

    @Override
    public void name() {
        System.out.println("五菱宏光");
    }
}

class Tsla1 implements Car1 {

    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
