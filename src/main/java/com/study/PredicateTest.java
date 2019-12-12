package com.study;

import java.util.function.Predicate;

/**
 * Predicate<T> 断言型接口 [boolean test(T t)]：接受参数，返回boolean
 *
 * @author administrator
 */
public class PredicateTest {
    private static boolean predicateValue(int value, Predicate<Integer> predicate) {
        return predicate.test(value);
    }

    public static void main(String[] args) {
        System.out.println("是否偶数：" + predicateValue(18, x -> x % 2 == 0));
    }
}
