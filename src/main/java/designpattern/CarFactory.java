package designpattern;


/**
 * 简单工厂模式，也叫静态工厂模式
 * 不修改代码，新增一个产品car，做不到
 * 没有满足开闭原则
 */
public class CarFactory {

    //方法一
    public static Car getCar(String car){
        if (car.equals("五菱宏光")){
            return new Wuling();
        }else if(car.equals("特斯拉")){
            return new Tsla();
        }else {
            return null;
        }
    }

    //方法二
    public static Car getWuling(){
            return new Wuling();
    }
    public static Car getTesla(){
        return new Tsla();
    }
}
