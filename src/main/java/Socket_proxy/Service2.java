package Socket_proxy;

import SocketTest.Score;
import SocketTest.StateService;
import SocketTest.StateServiceImpl;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Service2 {
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(8088);
        while (true){
            Socket ss = s.accept();
            process(ss);
            ss.close();
        }
    }

    public static void process(Socket ss) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(ss.getOutputStream());
        ObjectInputStream oos = new ObjectInputStream(ss.getInputStream());
        String methodName = oos.readUTF();
        Class[] paramsType = (Class[]) oos.readObject();
        Object[] params = (Object[]) oos.readObject();
        StateService s = new StateServiceImpl();
        Class clazz = s.getClass();
        Method m = clazz.getMethod(methodName,paramsType);
        Score result = (Score) m.invoke(s,params);
        out.writeObject(result);
        out.flush();
    }
}
