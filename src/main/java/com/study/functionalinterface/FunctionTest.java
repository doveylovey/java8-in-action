package com.study.functionalinterface;

import java.util.function.Function;

/**
 * Function<T, R> 函数型接口 [R apply(T t)]：接受参数，有返回参数
 *
 * @author administrator
 */
public class FunctionTest {
    private static int operateValue(int value, Function<Integer, Integer> function) {
        return function.apply(value);
    }

    private static int operateValue(int value, Function<Integer, Integer> srcFun, Function<Integer, Integer> destFun) {
        return srcFun.andThen(destFun).apply(value);
    }

    private static void demo() {
        Function<Integer, Integer> times2 = i -> i * 2;
        Function<Integer, Integer> squared = i -> i * i;
        System.out.println("结果应为8：" + times2.apply(4));
        System.out.println("结果应为16：" + squared.apply(4));
        // 【compose()方法先执行参数，再执行调用者】先4×4然后16×2，即先执行apply(4)，再times2的apply(16)
        System.out.println("结果应为32：" + times2.compose(squared).apply(4));
        // 【andThen()方法先执行调用者，再执行参数】先4×2然后8×8，即先执行times2的函数，再执行squared的函数
        System.out.println("结果应为64：" + times2.andThen(squared).apply(4));
        // identity()方法返回当前正在执行的方法，即执行squared的函数，再直接返回结果
        System.out.println("结果应为16：" + Function.identity().compose(squared).apply(4));
    }

    public static void main(String[] args) {
        demo();

        int value = 10;
        int applyInner = operateValue(value, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return 5 + t;
            }
        });
        System.out.println("结果1：" + applyInner);

        int applyLambda = operateValue(value, t -> t + 5);
        System.out.println("结果2：" + applyLambda);

        int andThenInner = operateValue(value, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return 3 + t;
            }
        }, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return 7 + t;
            }
        });
        System.out.println("结果3：" + andThenInner);

        int andThenLambda = operateValue(value, val -> val + 3, val -> val + 7);
        System.out.println("结果4：" + andThenLambda);
    }
}
