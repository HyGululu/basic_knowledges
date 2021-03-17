package mapmapmap;


public class MyMap {


    public static void main(String[] args) {

        MyMap myMap = new MyMap();
        myMap.put("zhangsan", "zhangsan");
        myMap.put("lisi", "lisi");
        myMap.put("wangwu", "wangwu");
        myMap.put("zhaoliu", "zhaoiu");
        myMap.put("qianqi", "qianqi");
        //System.out.println(myMap.get("zhangsan"));

        //数组：采用一连串的存储空间来存储数据；查询快，插入慢
        Integer[] integers = new Integer[10];
        integers[0] = 0;
        integers[1] = 1;
        integers[2] = 2;
        integers[9] = 9;

        //链表
        Node node = new Node(15);
        node.next = new Node(1);
        node.next.next = new Node(9);

        //哈希算法（散列）

    }

    static class Node {
        public Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
        //链表：物理存储单元上非连续，非顺序的存储结构；插入快，查找慢
    }


    /***
     * 实现put原理
     * 输出  key value hashcode 等 hash算法
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        //hash函数
        System.out.printf("key:%s,hash值:%s,存储位置:%s\r\n", key, key.hashCode(), Math.abs(key.hashCode() % 15));


    }

    /*
    线性表的两种数据存储结构：数组、链表
    数组，从栈中分配存储空间
    链表，从堆中分配存储空间
    逻辑结构：都是线性表
    存储方式：
    数组：连续的存储内存
    链表：若干节点组成，每个节点包含数据域和指针域


     */
}
