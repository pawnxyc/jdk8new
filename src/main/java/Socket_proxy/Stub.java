package Socket_proxy;

import SocketTest.Score;
import SocketTest.StateService;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

import static java.lang.reflect.Proxy.getProxyClass;

public class Stub{
    public static StateService getStub() {
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8088);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                String methodName = method.getName();
                Class[] params = method.getParameterTypes();
                oos.writeUTF(methodName);
                oos.writeObject(params);
                oos.writeObject(args);
                oos.flush();

                ObjectInputStream ooi = new ObjectInputStream(s.getInputStream());
                Score result= (Score) ooi.readObject();
                oos.close();
                s.close();
                return result;

            }
        };
        Object o = Proxy.newProxyInstance(StateService.class.getClassLoader(),
                new Class[]{StateService.class},h);
        return (StateService)o;
    }
}
