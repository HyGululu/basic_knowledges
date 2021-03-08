
Singleton Pattern
（单例模式）：
    Ensure a class has only one instance, and provide a global point of access to it.
    （确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。）


单例模式有三大要点：
构造方法私有化；
-- private Singleton() { }
实例化的变量引用私有化；
-- private static final Singleton APP_INSTANCE = new Singleton();
获取实例的方法共有
-- public static SimpleSingleton getInstance() {
-- return APP_INSTANCE;
-- }

反射，通过calss文件，将落到内存，找到class文件，new个instance，反序列化的方式
枚举单例不会被反序列化，枚举类没有构造方法，反序列化返回的只是这个值，和单例创建的同一个对象，

Spring依赖注入Bean实例默认是单例的
spring的bean工厂保证单例
Spring 为啥默认把bean设计成单例的