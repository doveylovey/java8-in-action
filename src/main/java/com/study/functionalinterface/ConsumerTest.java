package com.study.functionalinterface;

import java.util.function.Consumer;

/**
 * Consumer<T> 消费型接口 [void accept(T t)]: 接受参数, 没有返回
 *
 * @author administrator
 */
public class ConsumerTest {
    private static void printValue(String value, Consumer<String> consumer) {
        consumer.accept(value);
    }

    public static void main(String[] args) {
        String str = "test";
        printValue(str, s -> System.out.println("结果：" + s.toUpperCase()));
    }
}
