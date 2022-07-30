package ch11.list;

import java.util.Vector;

public class VectorEx1 {
    public static void main(String[] args) {
        Vector v = new Vector(5);
        v.add("1");
        v.add("2");
        v.add("3");
        print(v);

        v.trimToSize(); // 빈 공간을 없앤다
        System.out.println("========= After trimToSize() ========");
        print(v);

        v.ensureCapacity(6);
        System.out.println("======= After ensureCapacity(6) =======");
        print(v);

        v.setSize(7);
        System.out.println("========= After setSize(7) ==========");
        print(v);

        v.clear();
        System.out.println("========== After clear() ======");
        print(v);
    }

    private static void print(Vector v) {
        System.out.println(v);
        System.out.println("v.size() = " + v.size());
        System.out.println("v.capacity() = " + v.capacity());
    }
}
