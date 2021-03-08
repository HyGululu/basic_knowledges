package designpattern;

public class SingletonPatternTest {

    //可能会浪费空间
    private byte[] date1 = new byte[1024 * 1024];
    private byte[] date2 = new byte[1024 * 1024];
    private byte[] date3 = new byte[1024 * 1024];
    private byte[] date4 = new byte[1024 * 1024];

    //饿汉式单例
    //单例模式：构造器私有
    private SingletonPatternTest() {
    }

    private final static SingletonPatternTest SINGLETON_PATTERN_TEST = new SingletonPatternTest();

    private static SingletonPatternTest getInstance() {
        return SINGLETON_PATTERN_TEST;
    }
}
