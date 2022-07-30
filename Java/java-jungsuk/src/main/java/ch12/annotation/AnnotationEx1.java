package ch12.annotation;

public class AnnotationEx1 {
    public static void main(String[] args) {
        Parent p = new Child();

        p.parentMethod();
    }

}

class Parent{
    void parentMethod() {
        System.out.println("parent");
    }
}

class Child extends Parent {
    @Override
    void parentMethod() {
        System.out.println("child");
    }
}
