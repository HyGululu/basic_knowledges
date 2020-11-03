package rpcdemo.rpc08_Hessian;

import com.caucho.hessian.io.Hessian2Output;
import rpcdemo.rpc1.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.apache.commons.lang3.SerializationUtils.deserialize;

public class HelloHessian {
    public static void main(String[] args) throws IOException {
        User u = new User(1, "ghy");
        byte[] bytes =serialize(u);
        System.out.println(bytes.length);
        User u1 =(User)deserialize(bytes);
        System.out.println(u1);
    }

    public static byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output=new Hessian2Output(baos);
        output.writeObject(o);
        output.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }

}
