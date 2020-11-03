package jichu;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射操作泛型-了解
 */
public class ReflectionTest10 {

    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ReflectionTest10.class.getMethod("test01", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes){
            System.out.println("====="+genericParameterType);
            if(genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actulTypeArgument :actualTypeArguments){
                    System.out.println("test01泛型的参数信息"+actulTypeArgument);

                }

            }


        }

         method = ReflectionTest10.class.getMethod("test02",null);
         Type genericReturnType = method.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actulTypeArgument :actualTypeArguments){
                System.out.println("test02泛型的参数信息"+actulTypeArgument);

            }

        }


    }



}
/**
 *
 */