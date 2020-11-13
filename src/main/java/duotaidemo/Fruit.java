package duotaidemo;

/*
多态
程序运行，当调用对象Fruit f的方法taste时，
JVM查找Fruit对象类的方法表以确定taste方法的直接引用地址，
到底来自Apple还是Pear，确定后才真正调用对应子类的taste方法
 */
abstract class Fruit {
    abstract String taste();
}

class Apple extends Fruit {

    @Override
    String taste() {
        return "酸酸的";
    }
}

class Pear extends Fruit {

    @Override
    String taste() {
        return "甜甜的";
    }
}

class TestDuoTai {
    public static void main(String[] args) {
        Fruit fruit = new Apple();
        System.out.println(fruit.taste());
    }
}