package designpattern.singletonpattern;

/*

掌握哦

在内存里只会创建且创建一个对象，避免内存浪费
分类：饿汉式（在程序调用时候才创建实例）；懒汉式（在程序加载时就已经创建好实例，等待被调用）


让构造方法私有；一个类仅有一个实例，


饿汉式
这种方式在类加载时就完成了初始化
类加载到内存后，就实例化一个单例，JVM保证线程安全，推荐使用这个
缺点：不管是否用到，类加载时候就完成实例化，不用的时候，一加载就实例化了，Class.forName("")
 */
public class SingleObject {
    //创建 SingleObject 的一个对象
    private  static  final SingleObject instance =new SingleObject();

    //让构造函数为 private，这样该类就不会被实例化,
    // 保证SingleObject在内存中只有一个实例，出了这个类，其他类new不出来
    private SingleObject(){}
    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println(" hello ,Single!");
    }
    public static void main(String[] args) {
        SingleObject o1 = SingleObject.getInstance();
        SingleObject o2 = SingleObject.getInstance();
        System.out.println(o1==o2);//结果是true，说明不管调多少次getInstance都是一个实例
    }
}
