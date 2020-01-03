package com.study.stream;

import java.util.Arrays;
import java.util.List;

/**
 * JDK8 中 Stream API 测试类
 *
 * @author administrator
 */
public class StreamTest {
    public static List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
        System.out.println("\n========== parallelStream + forEach ==========");
        // TODO 数据展示的顺序不一定会是 0、1、2、3、4、5、6、7、8、9，而可能是任意的顺序
        numbers.parallelStream().forEach(System.out::println);
    }

    public static void test02() {
        System.out.println("\n========== parallelStream + forEachOrdered ==========");
        // TODO 数据展示的顺序是原数据的顺序
        numbers.parallelStream().forEachOrdered(System.out::println);
    }
}
