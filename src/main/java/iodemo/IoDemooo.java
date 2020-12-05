package iodemo;

import java.io.*;
import java.math.BigInteger;

/*
IO流
内存--硬盘
Java中的流分为两种：一种是字节流，另一种是字符流。
IO流分别由四个抽象类来表示（两输入两输出）:
InputStream，OutputStream，Reader，Writer。

OutputStream:ByteArrayOutputStream;ObjectOutputStream
InputStream:
 */
public class IoDemooo {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        String s = "等风也等你";
        oos.writeObject(s);
        String str = baos.toString();
        System.out.println(str.toString()); // 打印
        byte[] baStr = baos.toByteArray();
        byte[] gbStr = str.getBytes();
        byte[] testStr = baStr;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < testStr.length; i++) {
            sb.append(Integer.toBinaryString(testStr[i]) + " ");
        }
        System.out.println(sb.toString());
    }

    public void deserializeok() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        BigInteger bi = new BigInteger("0");
        oos.writeObject(bi);
        byte[] str = baos.toByteArray();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(str)));
        Object obj = ois.readObject();
        System.out.println("obj: "+ obj.toString());
        System.out.println("java.math.BigInteger: "+obj.getClass().getName());
        System.out.println(((BigInteger) obj).intValue());
    }
}
