package jichu.Thread;

/**
 * 模拟龟兔赛跑
 * 首先for循环步数，判断比赛是否结束
 * 打印一个胜利者
 * 比赛开始
 * 模拟休息
 */
public class Race implements Runnable {
    //胜利者
    private static String winner;

    public void run() {
        for (int i = 0; i <= 1000; i++) {

            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子")&&i%10==0){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(i);
            //步数为100，如果比赛结束了，就终止程序
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--->跑了" + i + "步数");
        }
    }

    //判断是否比赛完成
    private boolean gameOver(int steps) {
        //判断是否有胜利者
        if (winner != null) {
            return true;
        }
        {
            if (steps == 1000) {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}


