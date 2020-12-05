package springdemo;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleCornRunDemo  {
    @Scheduled(cron = "0 0/1 * * * ?")
    public void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("test1==="+ sdf.format(new Date()));
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void test2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("test2===="+ sdf.format(new Date()));
    }
}
