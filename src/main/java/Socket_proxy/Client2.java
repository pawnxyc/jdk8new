package Socket_proxy;

import SocketTest.Score;
import SocketTest.StateService;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws Exception {
        StateService proxy = Stub.getStub();
        Score s = proxy.getScoreByState(100);
        System.out.println(s+"========");
    }
}
