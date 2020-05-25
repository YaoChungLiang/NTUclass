import java.lang.reflect.Method;
public class ReflectMethodArgs{
    public static void main(String[] args) throws Exception{
        Class[] paramTypes = new Class[1];
        paramTypes[0] = String.class;
        Method method1 = ReflectMethodArgs.class.getMethod("method1", paramTypes);
        
        ReflectMethodArgs demo = new ReflectMethodArgs();
        demo.method2(demo, method1, "Hello world");
    }

    public void method1(String message){
        System.out.println(message);
    }

    public void method2(Object object, Method method, String message)throws Exception {
        Object[] params = new Object[1];
        params[0] = message;
        method.invoke(object, params);
    }
}
