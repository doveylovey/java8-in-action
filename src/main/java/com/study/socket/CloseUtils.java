package com.study.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 关闭资源的工具类
 *
 * @author Administrator
 */
public class CloseUtils {
    private final static Logger logger = LoggerFactory.getLogger(CloseUtils.class);

    private CloseUtils() {
    }

    public static void closeServerSocket(ServerSocket serverSocket) {
        try {
            serverSocket.close();
        } catch (IOException e) {
            logger.error("关闭 ServerSocket 对象失败！", e);
        }
    }

    public static void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            logger.error("关闭 Socket 对象失败！", e);
        }
    }

    public static void closeInputStream(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            logger.error("关闭 InputStream 对象失败！", e);
        }
    }

    public static void closeOutputStream(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            logger.error("关闭 OutputStream 对象失败！", e);
        }
    }
}
