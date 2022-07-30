package ch14.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamEx6 {
    public static void main(String[] args) {
        Student1[] stuArr = {
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 290),
                new Student1("감자바", 3, 180),
        };
        // 학생 이름만 뽑아서 List<String>에 저장
        List<String> names = Stream.of(stuArr).map(Student1::getName).collect(toList());
        System.out.println("names = " + names);
        // 스트림을 배열로 변환
        Student1[] stuArr2 = Stream.of(stuArr).toArray(Student1[]::new);

        for (Student1 s : stuArr2) {
            System.out.println("s = " + s);
        }
        //스트림을 Map<String, Student>로 변환, 학생 이름이 key
        Map<String, Student1> stuMap = Stream.of(stuArr).collect(toMap(s -> s.getName(), p -> p));

        for (String name : stuMap.keySet()) {
            System.out.println( name + "=" + stuMap.get(name));
        }

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr).collect(summingInt(Student1::getTotalScore));

        System.out.println("count = " + count);
        System.out.println("totalScore = " + totalScore);

        totalScore = Stream.of(stuArr).collect(reducing(0, Student1::getTotalScore, Integer::sum));

        System.out.println("totalScore = " + totalScore);

        Optional<Student1> topStudent = Stream.of(stuArr)
                                        .collect(maxBy(Comparator.comparingInt(Student1::getTotalScore)));

        System.out.println("topStudent = " + topStudent.get());

        IntSummaryStatistics stat = Stream.of(stuArr).collect(summarizingInt(Student1::getTotalScore));
        System.out.println("stat = " + stat);

        String stuNames = Stream.of(stuArr).map(Student1::getName).collect(joining(",","{","}"));

        System.out.println("stuNames = " + stuNames);


    }
}

class Student1 implements Comparable<Student1> {
    String name;
    int ban;
    int totalScore;

    public Student1(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student1 s) {
        return s.totalScore - this.totalScore;
    }
}