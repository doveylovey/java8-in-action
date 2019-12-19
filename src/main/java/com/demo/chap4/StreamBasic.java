package com.demo.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamBasic {
    public static void main(String... args) {
        // Java 7
        System.out.println("=====>使用Java 7实现筛选、排序");
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
        // Java 8
        System.out.println("=====>使用Java 8实现筛选、排序");
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        System.out.println("=====>使用Java 8实现分组");
        groupDishesInJava8(Dish.menu).forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public static Map<Dish.Type, List<Dish>> groupDishesInJava8(List<Dish> dishes) {
        return dishes.stream().collect(Collectors.groupingBy(Dish::getType));
    }
}
