package com.study.optional;

import java.util.Optional;

/**
 * Optional 类测试
 *
 * @author administrator
 */
public class Optional01Tests {
    public static void main(String[] args) {
        // 测试1
        OptionalUser user01 = test01();
        System.out.println("test01()：" + user01);
        // 测试2
        OptionalUser user02 = test02();
        System.out.println("test02()：" + user02);
        // 测试3
        test03();
    }

    public static Optional<OptionalUser> testNotNUll() {
        OptionalUser user = new OptionalUser(1L, "张三", null);
        // 这里 user 不能为 null
        return Optional.of(user);
    }

    public static Optional<OptionalUser> testNull() {
        OptionalUser user = null;
        // 这里 user 可以为 null
        return Optional.ofNullable(user);
    }

    /**
     * 存在即返回，无则提供默认值
     *
     * @return
     */
    public static OptionalUser test01() {
        Optional<OptionalUser> user = testNull();
        // 反例：return user.isPresent() ? user.get() : null;
        return user.orElse(null);
    }

    /**
     * 存在即返回，无则由函数来产生
     *
     * @return
     */
    public static OptionalUser test02() {
        Optional<OptionalUser> user = testNotNUll();
        // 反例：return user.isPresent() ? user.get() : createOptionalUser();
        return user.orElseGet(() -> createOptionalUser());
    }

    /**
     * 存在才对它做点什么
     */
    public static void test03() {
        Optional<OptionalUser> user = testNotNUll();
        // 反例
        if (user.isPresent()) {
            System.out.println(user.get());
        }
        // 正确写法
        user.ifPresent(System.out::println);
    }

    /**
     * 通过函数来创建 OptionalUser 对象
     *
     * @return
     */
    public static OptionalUser createOptionalUser() {
        return new OptionalUser(0L, "CREATE", null);
    }
}
