package com.demo.chap5;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String... args) throws Exception {
        // Stream.of
        System.out.println("===>Stream.of()示例【遍历】：");
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        System.out.println("===>Stream.empty()示例：");
        Stream<String> emptyStream = Stream.empty();

        // Arrays.stream
        System.out.println("===>Arrays.stream()示例【求和】：");
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());

        // Stream.iterate
        System.out.println("===>Stream.iterate()示例1：");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // fibonnaci with iterate
        System.out.println("===>Stream.iterate()示例2：");
        int[] ints = new int[]{0, 1};
        Stream.iterate(ints, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        System.out.println("===>Stream.iterate()示例3：");
        Stream.iterate(ints, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // random stream of doubles with Stream.generate
        System.out.println("===>Stream.generate()示例【随机数】：");
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        // stream of 1s with Stream.generate
        System.out.println("===>IntStream.generate()示例1：");
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("===>IntStream.generate()示例2：");
        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        System.out.println("===>IntStream.generate()示例3：");
        IntStream.generate(fib)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("===>统计一个文件中不同单单词数量：");
        // 获取指定文件的 URL
        URL url = BuildingStreams.class.getClassLoader().getResource("com/demo/chap5/data.txt");
        // 通过 URL 获取文件的绝对路径
        File file = new File(url.getFile());
        long uniqueWords = Files.lines(file.toPath(), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        System.out.println("在 " + file.getName() + " 文件中共有 " + uniqueWords + " 个不同单词");
    }
}
