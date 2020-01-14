package com.study.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * socket 客户端
 *
 * @author Administrator
 */
public class MyClient01 {
    public static void main(String[] args) {
        // 获取用户输入的数据
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数据：");
        String inputData = input.nextLine();

        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            // 开启一个Socket端口
            socket = new Socket("127.0.0.1", 6666);
            outputStream = socket.getOutputStream();
            outputStream.write(inputData.getBytes());
            // 获取服务端回传的数据
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            len = inputStream.read(buffer);
            String getData = new String(buffer, 0, len);
            System.out.println("从服务端获取的数据：" + getData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeInputStream(inputStream);
            CloseUtils.closeOutputStream(outputStream);
            CloseUtils.closeSocket(socket);
        }
    }
}
