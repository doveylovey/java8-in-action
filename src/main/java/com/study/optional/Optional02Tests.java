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
        test01();
        // 测试02
        test02();
        // 测试03
        List<OptionalOrder> orderList = test03();
        orderList.forEach(System.out::println);
        // 测试04
        String s = test04();
        System.out.println(s);
    }

    /**
     * map 若对象存在，则进行转换。jdk8 之前写法相当于 {@link #test01_1()}
     */
    public static void test01() {
        OptionalUser user = null;
        Optional<OptionalUser> optional = Optional.ofNullable(user);
        // map 返回类型依旧为 Optional 类型
        Optional<Long> long1 = optional.map(u -> u.getUserId());
        System.out.println("long1：" + long1);
        // 若使用 orElse()，只要出现 null 值，那么便转换为 1
        Long long2 = optional.map(u -> u.getUserId()).orElse(-1L);
        System.out.println("long2：" + long2);
    }

    public static void test01_1() {
        OptionalUser user = null;
        if (user != null && user.getUserId() != null) {
            System.out.println(user.getUserId());
        } else {
            System.out.println(1);
        }
    }

    /**
     * filter 过滤条件，不符合条件则抛异常(或返回 null)
     */
    public static void test02() {
        OptionalUser user1 = new OptionalUser(20L, "aa", null);
        Optional<OptionalUser> user2 = Optional.of(user1);
        // 中间操作，不符合条件则为 null
        OptionalUser user3 = user2.filter(u -> "ab".equals(u.getUserName())).orElse(null);
        System.out.println(user3);
        // 中间操作，不符合条件则抛出异常
        OptionalUser user4 = user2.filter(u -> "aa".equals(u.getUserName())).orElseThrow(RuntimeException::new);
        System.out.println(user4);
    }

    /**
     * 当 user.isPresent() 为真，获得它关联的 orders，为假则返回一个空集合时，用上面的 orElse()、orElseGet()方法都乏力时，那就是 map 函数的责任
     *
     * @return
     */
    public static List<OptionalOrder> test03() {
        Optional<OptionalUser> user = Optional.ofNullable(createOptionalUser());
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
    public static String test04() {
        Optional<OptionalUser> user = Optional.ofNullable(createOptionalUser());
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
