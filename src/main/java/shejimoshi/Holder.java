package shejimoshi;

public class Holder {
    //静态内部类

    //构造器私有
    private Holder(){

    }
    private static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    private static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
