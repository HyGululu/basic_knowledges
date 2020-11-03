package jichu.Thread;


/**
 *
 * 静态代理就是线程底部的实现原理
 *
 *
 * 静态代理模式总结
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 *
 * 好处：
 * 代理对象可以做很多真实对象做不了的事儿
 * 真实对象就可以专注做自己的事情
 */

public class StacticProxy {

    public static void main(String[] args) {

        //之前不用Lambda表达式时候
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱你");
            }
        }).start();
        //Lambda 表达式
        new Thread(()-> System.out.println("我爱你")).start();
        //类似，上面Thread也是实现了Runnable接口
        new WeddingCompany(new You()).Happymarry();


        You you = new You();//你 要结婚

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.Happymarry();
    }
}

interface Marry{
    //结婚
    void Happymarry();
}

//真实角色：你 去结婚
class You implements Marry {


    public void Happymarry() {
        System.out.println("要结婚了，超开心");
    }
}

//代理角色：帮助你结婚
class WeddingCompany implements Marry {

    //代理谁---》真实目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }


    public void Happymarry() {
        before();
        this.target.Happymarry();//这就是真实对象
        after();
    }

    private void before() {
        //结婚前
        System.out.println("结婚前，布置现场");
    }

    private void after() {
        System.out.println("结婚后，收尾款");
    }
}


/**
 *
 * 实现静态代理对比Thread
 *静态代理
 * eg.
 * 你：真是角色
 * 婚庆公司：代理你，帮你处理结婚事情
 * 结婚：实现结婚接口就可以了
 *
 *
 * Lambda 表达式：
 * JDK8 的一个新特性，可以取代大部分的匿名内部类，
 * 写出更优雅的 Java 代码，尤其在集合的遍历和其他集合操作中，可以极大地优化代码结构
 *
 *
 * 久旱逢甘露
 * 他乡遇故知
 * 洞房花烛夜
 * 金榜题名时
 * */