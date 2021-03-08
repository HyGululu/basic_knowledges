package designpattern;

/**
 * 工厂模式-简单工厂模式
 */
public class Consumer {
    public static void main(String[] args) {
        //原始方法，了解接口，了解实现类
        //1、Car car = new Wuling();
        //Car car2 = new Tsla();

        //2、使用工厂模式创建
        Car car = CarFactory.getCar("五菱宏光");
        Car car2 = CarFactory.getCar("特斯拉");


        car.name();
        car2.name();
    }
}

interface Car{
    void name();
}

class Wuling implements Car {

    @Override
    public void name() {
        System.out.println("五菱宏光");
    }
}

class Tsla implements Car {

    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}

class DaZhong implements Car {

    @Override
    public void name() {
        System.out.println("大众");
    }
}