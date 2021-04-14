package designpattern.dynamicproxy.rpcanddyn;

public class MyClassLoader  extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        /*自己另外写一个getClassData()
                  通过IO流从指定位置读取xxx.class文件得到字节数组*/
        byte[] datas = getClassData(name);
        if (datas==null){
            throw new ClassNotFoundException("类找不到： "+name);
        }
        //调用类加载器本身的defineClass()方法，由字节码得到Class对象
        return this.defineClass(name,datas,0,datas.length);
    }

    private byte[] getClassData(String name) {
        return new byte[0];
    }
}
/*
要定义类加载器，
需要继承ClassLoader类，并覆盖findClass()方法：
 */