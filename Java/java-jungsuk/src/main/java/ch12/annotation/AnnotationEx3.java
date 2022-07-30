package ch12.annotation;

import java.util.ArrayList;

public class AnnotationEx3 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        NewClass2 nc = new NewClass2();

        nc.oldField = 10;

        System.out.println(nc.getOldField());

        @SuppressWarnings("unchecked")
        ArrayList<NewClass2> list = new ArrayList();
        list.add(nc);
    }
}

class NewClass2 {
    int newField;


    @Deprecated
    int oldField;

    public int getNewField() {
        return newField;
    }

    public int getOldField() {
        return oldField;
    }
}
