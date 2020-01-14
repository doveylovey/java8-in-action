package com.study.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Optional 类测试
 *
 * @author administrator
 */
public class OptionalTests {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private Long id;
        private String name;
    }

    public static void main(String[] args) {
        // 测试1
        User user01 = test01();
        System.out.println("test01()：" + user01);
        // 测试2
        User user02 = test02();
        System.out.println("test02()：" + user02);
        // 测试3
        test03();
    }

    public static Optional<User> testNotNUll() {
        User user = new User(1L, "张三");
        // 这里 user 不能为 null
        return Optional.of(user);
    }

    public static Optional<User> testNull() {
        User user = null;
        // 这里 user 可以为 null
        return Optional.ofNullable(user);
    }

    /**
     * 存在即返回，无则提供默认值
     *
     * @return
     */
    public static User test01() {
        Optional<User> user = testNull();
        // 反例：return user.isPresent() ? user.get() : null;
        return user.orElse(null);
    }

    /**
     * 存在即返回，无则由函数来产生
     *
     * @return
     */
    public static User test02() {
        Optional<User> user = testNotNUll();
        // 反例：return user.isPresent() ? user.get() : createUser();
        return user.orElseGet(() -> createUser());
    }

    /**
     * 存在才对它做点什么
     */
    public static void test03() {
        Optional<User> user = testNotNUll();
        // 反例
        if (user.isPresent()) {
            System.out.println(user.get());
        }
        // 正确写法
        user.ifPresent(System.out::println);
    }

    /**
     * 通过函数来创建 User 对象
     *
     * @return
     */
    public static User createUser() {
        return new User(0L, "CREATE");
    }
}
