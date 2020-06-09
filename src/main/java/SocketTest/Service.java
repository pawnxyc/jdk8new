package SocketTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(8080);
        while (true){
            Socket ss = s.accept();
            process(ss);
            ss.close();
        }
    }

    public static void process(Socket ss) throws Exception {
        StateService simp = new StateServiceImpl();
        DataInputStream ds = new DataInputStream(ss.getInputStream());
        int state = ds.readInt();
        System.out.println(state);
        Score s= simp.getScoreByState(state);
        DataOutputStream outputStream = new DataOutputStream(ss.getOutputStream());
        outputStream.writeInt(state);
        outputStream.writeUTF(s.toString());
        outputStream.flush();
    }
}
