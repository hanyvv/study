package ch12.generics;

import java.util.ArrayList;


class Fruit implements Eatable{
    String name;
    int weight;

    public Fruit() {
    }

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return name + "(" + weight + ")";
    }
}

class Apple extends Fruit {
    public Apple() {
    }

    public Apple(String name, int weight) {
        super(name, weight);
    }

    public String toString() {
        return name + "(" + weight + ")";
    }
}

class Grape extends Fruit {
    public Grape() {
    }

    public Grape(String name, int weight) {
        super(name, weight);
    }

    public String toString() {
        return name + "(" + weight + ")";
    }
}

class Toy {
    public String toString() {
        return "Toy";
    }
}

public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Toy> toyBox = new Box<>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());

        appleBox.add(new Apple());
        appleBox.add(new Apple());

        toyBox.add(new Toy());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("toyBox = " + toyBox);
    }
}

class Box<T>{

//    static int compare(T t1, T t2) {
//        return 0;
//    }  static 맴버에 타입 변수 T를 사용 X, T는 인스턴스 변수로 간주됨

    //static 메서드에 지네릭 타입을 선언하고 사용하는 것은 가능
    static <T> int compare(T t1, T t2) {
     return 0;
    }

    ArrayList<T> list = new ArrayList<>();
    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    ArrayList<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}

