package rpcdemo.rpc09_Hessian02;

import com.caucho.hessian.io.Hessian2Output;
import rpcdemo.rpc1.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HessianVSJDK {
    public static void main(String[] args) throws IOException {
        User u = new User(1, "ghyhhh");
        System.out.println("hessian: "+hessianSerialize(u).length+"字节");
        //System.out.println("jkd: "+jdkSerialize(u).length+"字节");
    }

    private static byte[] hessianSerialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);
        output.writeObject(o);
        output.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }
}
