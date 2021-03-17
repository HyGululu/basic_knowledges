package collections;

/*
StringBuffer 线程安全
StringBuilder 线程非安全
 */
public class ThreadStringBuffer {
    public static void main(String[] args) {
        MyString myString = new MyString();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        myString.append(1);
                        stringBuilder.append("1");
                        stringBuffer.append("1");
                        System.out.println(myString.getNum() + "-" + stringBuilder.length() + " - " + stringBuffer.length());

                    }
                }
            }).start();

        }

    }

    private static class MyString {
        private Integer num = 0;

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public synchronized void append(Integer num) {
            this.num = this.num + num;
        }

    }
}
