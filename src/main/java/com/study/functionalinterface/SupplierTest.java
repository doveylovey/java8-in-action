package com.study.functionalinterface;

import java.util.function.Supplier;

/**
 * Supplier<T> 供给型接口 [T get()]：不接受参数，有返回值
 *
 * @author administrator
 */
public class SupplierTest {
    private static String getOrDefault(String value, Supplier<String> supplier) {
        return (value == null || "".equals(value)) ? supplier.get() : value;
    }

    public static void main(String[] args) {
        String name = "";
        System.out.println("结果：" + getOrDefault(name, () -> "test"));
    }
}
