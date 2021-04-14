package designpattern.dynamicproxy;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class ProxyDemoTest03 {
    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        System.out.println(myProxy.getClass().getName());
        System.out.println(myProxy instanceof Serializable);
        System.out.println(myProxy instanceof Collection);

    }
}
/*代理对象的本质就是：
        和目标对象实现相同接口的实例。
        代理Class可以叫任何名字，
        whatever，只要它实现某个接口，就能成为该接口类型。
        */

class MyProxy implements Serializable, Collection {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}

