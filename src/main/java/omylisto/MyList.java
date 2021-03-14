package omylisto;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过两个线程对ArrayList添加元素，复现两种线程不安全情况
 *  数组越界异常 ArrayIndexOutOfBoundsException：多个线程进行add操作时
 *  元素值覆盖和为空问题：elementData[size++] = e 设置值的操作
 */
public class MyList {

    public static void main(String[] args) throws InterruptedException {

        final List<Integer> list = new ArrayList<>();
        //线程A将1--1000添加到列表
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //线程B将1001--2000添加到列表
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1001; i < 2000; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(1000);
        //打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素" + list.get(i));
        }
    }
}

/*
执行add方法时，主要分为两步：

首先判断elementData数组容量是否满足需求——》判断如果将当前的新元素加到列表后面，列表的elementData数组的大小是否满足，如果size + 1的这个需求长度大于了elementData这个数组的长度，那么就要对这个数组进行扩容；
之后在elementData对应位置上设置元素的值。
 */