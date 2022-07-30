package ch14.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx0 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();//list를 데이터 소스로 하는 새로운 스트림 생성
        intStream.forEach(System.out::print); //최종연산

        //stream은 1회용. stream에 대해 최종연산을 수행하면 stream이 닫힌다.

        Stream<String> strStream = Stream.of("a", "b", "c");
        strStream.forEach(System.out::println);

        IntStream is = new Random().ints( 1, 47);
        is.distinct().limit(5).forEach(System.out::println);

        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2); //종속적
        iterate.limit(10).forEach(System.out::println);

        Stream<Integer> generate = Stream.generate(() -> 1); //독립적
        generate.limit(10).forEach(System.out::println);

    }
}
