package shejimoshi.singletonpattern;

/*

懒汉式
线程不安全，多线程访问的时候有影响

 */
public class SingleObject2 {
    //创建 SingleObject2 的一个对象
    private static SingleObject2 instance;
    //让构造函数为 private，这样该类就不会被实例化
    //单例模式的构造方法都是私有的, 防止其他对象new
    private SingleObject2(){
        //完成初始化等操作...
        // }
    }
    //返回单例模式对象
    public static SingleObject2 getInstance() {
        ////懒汉式,  检查是否为空,如果是空, 再初始化
        if (instance == null){
            //如果不是空, 则直接返回实例.
            instance = new SingleObject2();
        }
        return instance;
    }

}
