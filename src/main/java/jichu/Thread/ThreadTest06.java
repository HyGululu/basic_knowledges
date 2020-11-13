/*
package jichu.Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

*/
/**
 * 线程创建方式三：实现Callable接口（了解）
 *
 * Callable好处：
 * 1、可以定义返回值
 * 2、可以抛出异常
 *
 *//*

//1、实现Callable接口
public class ThreadTest06 implements Callable<Boolean> {

    private String url;  //网络图片地址
    private String name; //保存文件名

    public ThreadTest06(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片的执行体
    //2、重写call方法
    public Boolean call(){
        WebDownLoader03 webDownLoader = new WebDownLoader03();
        webDownLoader.downloader(url,name);
        System.out.println("下载了文件名： "+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTest06 t1 = new ThreadTest06("https://img.diyijuzi.com/uploadfile/2020/0313/1584096698316.jpg","1.jpg");
        ThreadTest06 t2 = new ThreadTest06("https://img.diyijuzi.com/uploadfile/2020/0313/1584096713746.jpg","2.jpg");
        ThreadTest06 t3 = new ThreadTest06("https://img.diyijuzi.com/uploadfile/2020/0313/1584096706532.jpg","3.jpg");

        //4、创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //5、提交执行
        Future<Boolean> r1 = executorService.submit(t1);
        Future<Boolean> r2 = executorService.submit(t2);
        Future<Boolean> r3 = executorService.submit(t3);

        //6、获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        //7、关闭服务
        executorService.shutdown();
    }

}

//下载器
class WebDownLoader03{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}*/
