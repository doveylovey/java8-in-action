package com.study.optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Optional 类测试
 *
 * @author administrator
 */
public class Optional02Tests {
    public static void main(String[] args) {
        // 测试01
        List<OptionalOrder> orderList = test01();
        orderList.forEach(System.out::println);
        // 测试02
        String s = test02();
        System.out.println(s);
    }

    /**
     * 当 user.isPresent() 为真，获得它关联的 orders，为假则返回一个空集合时，用上面的 orElse()、orElseGet()方法都乏力时，那就是 map 函数的责任
     *
     * @return
     */
    public static List<OptionalOrder> test01() {
        Optional<OptionalUser> user = Optional.of(createOptionalUser());
        // jdk8 之前的做法
        /*if (user.isPresent()) {
            return user.get().getOrderList();
        } else {
            return Collections.emptyList();
        }*/
        return user.map(u -> u.getOrderList()).orElse(Collections.emptyList());
    }

    /**
     * map 是可能无限级联的，比如要获得 userName 的大写形式
     *
     * @return
     */
    public static String test02() {
        Optional<OptionalUser> user = Optional.of(createOptionalUser());
        return user.map(u -> u.getUserName())
                .map(name -> name.toLowerCase())
                .orElse(null);
    }

    /**
     * 通过函数来创建 OptionalUser 对象
     *
     * @return
     */
    public static OptionalUser createOptionalUser() {
        List<OptionalOrder> orderList = new ArrayList<>();
        orderList.add(new OptionalOrder(1L, 123L));
        orderList.add(new OptionalOrder(1L, 456L));
        orderList.add(new OptionalOrder(1L, 789L));
        return new OptionalUser(0L, "CREATE", orderList);
    }
}
