package mapmapmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestLock {
    private HashMap map = new HashMap();

    public TestLock(){
        Thread t1 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10000000; i++) {
                    map.put(new Integer(i),i);
                }
                System.out.println("t1 over");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10000000; i++) {
                    map.put(new Integer(i),i);
                }
                System.out.println("t2 over");
            }
        };
        Thread t3 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10000000; i++) {
                    map.put(new Integer(i),i);
                }
                System.out.println("t3 over");
            }
        };
        Thread t4 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10000000; i++) {
                    map.put(new Integer(i),i);
                }
                System.out.println("t4 over");
            }
        };
        Thread t5 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10000000; i++) {
                    map.put(new Integer(i),i);
                }
                System.out.println("t5 over");
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public static void main(String[] args) {
        new TestLock();
    }
}
