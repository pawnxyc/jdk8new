package SocketTest;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket so = new Socket(InetAddress.getLocalHost(),8080);
//        first write score into stream.
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        DataOutputStream ds = new DataOutputStream(bo);
        ds.writeInt(0);

        OutputStream outputStream = so.getOutputStream();
        outputStream.write(bo.toByteArray());
        outputStream.flush();

        InputStream bi = so.getInputStream();
        DataInputStream stream = new DataInputStream(bi);
        System.out.println(stream.readInt());
        System.out.println(stream.readUTF());
    }
}
