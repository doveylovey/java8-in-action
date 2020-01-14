package com.study.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * socket 服务端
 *
 * @author Administrator
 */
public class MyServer01 {
    private final static Logger logger = LoggerFactory.getLogger(MyServer01.class);

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(6666);
            boolean flag = true;
            while (flag) {
                // 接收客户端的请求
                System.out.println(">>>>>>>>>> 开始监听客户端数据 >>>>>>>>>>");
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                len = inputStream.read(buffer);
                String str = new String(buffer, 0, len);
                System.out.println("从客户端获取的数据：" + str);
                // 业务处理：大小写转化
                String upperCase = str.toUpperCase();
                // 向客户端写数据
                outputStream = socket.getOutputStream();
                outputStream.write(upperCase.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            logger.error("服务端异常！", e);
        } finally {
            CloseUtils.closeOutputStream(outputStream);
            CloseUtils.closeInputStream(inputStream);
            CloseUtils.closeSocket(socket);
            CloseUtils.closeServerSocket(serverSocket);
        }
    }
}
