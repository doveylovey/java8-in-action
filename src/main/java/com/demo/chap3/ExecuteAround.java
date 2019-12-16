package com.demo.chap3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ExecuteAround {
    public static void main(String... args) throws IOException {
        // method we want to refactor to make more flexible
        System.out.println("\n=====读取1行数据(原始方法)：");
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("\n=====读取1行数据(函数式接口)：");
        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        System.out.println("\n=====读取2行数据(Lambda表达式)：");
        String twoLines = processFile((BufferedReader b) -> b.readLine() + "\n" + b.readLine());
        System.out.println(twoLines);

        System.out.println("\n=====读取3行数据(Lambda表达式)：");
        String threeLines = processFile((BufferedReader b) -> b.readLine() + "\n" + b.readLine() + "\n" + b.readLine());
        System.out.println(threeLines);
    }

    public static String processFileLimited() throws IOException {
        InputStream in = ClassLoader.getSystemResourceAsStream("com/demo/chap3/data.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            return br.readLine();
        }
    }


    public static String processFile(BufferedReaderProcessor p) throws IOException {
        InputStream in = ClassLoader.getSystemResourceAsStream("com/demo/chap3/data.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
}
