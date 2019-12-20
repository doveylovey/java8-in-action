package com.demo.chap5;

import com.demo.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String... args) {
        // Filtering with predicate
        System.out.println("===>筛选出所有素菜：");
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        System.out.println("===>筛选出所有不重复的偶数：");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        System.out.println("===>热量超过300卡路里的菜：");
        List<Dish> dishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .collect(Collectors.toList());
        dishes.forEach(System.out::println);

        // Truncating a stream
        System.out.println("===>热量超过300卡路里的前三个菜：");
        List<Dish> dishesLimit3 = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        System.out.println("===>1、筛选出热量超过300卡路里的菜；2、跳过前2个后返回剩下的：");
        List<Dish> dishesSkip2 = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        dishesSkip2.forEach(System.out::println);

        System.out.println("===>筛选出前2个荤菜：");
        List<Dish> meatLimit2 = Dish.menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        meatLimit2.forEach(System.out::println);
    }
}
