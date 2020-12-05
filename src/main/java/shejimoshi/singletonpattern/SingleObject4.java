/*
package shejimoshi.singletonpattern;

*/
/*
枚举单例

java大牛写的，effctive java

不仅可以解决线程同步，还可以防止反序列化
 *//*

public enum SingleObject4{

    INSTANCE;

    //测试类，
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //100个线程，不同对象的hash码不同
            new Thread(() -> System.out.println(SingleObject4.INSTANCE().hashCode())).start();
        }
    }

}
*/
