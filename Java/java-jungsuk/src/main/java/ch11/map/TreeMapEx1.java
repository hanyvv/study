package ch11.map;

import java.util.*;

public class TreeMapEx1 {
    public static void main(String[] args) {
        String[] data = {"A", "K", "A", "K", "D", "K", "A", "A", "K", "K", "Z", "D"};

        TreeMap map = new TreeMap();

        for (int i = 0; i < data.length; i++) {
            if (map.containsKey(data[i])) {
                Integer val = (Integer) map.get(data[i]);
                map.put(data[i], val + 1);
            }else {
                map.put(data[i], 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        System.out.println(" = 기본정렬 =");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int val = ((int) entry.getValue());
            System.out.println(entry.getKey() + " : " + printBar('#', val) + " " + val);
        }

        System.out.println();

        Set set = map.entrySet();
        List list = new ArrayList(set);

        Collections.sort(list, new ValueComparator());

        it = list.iterator();
        System.out.println(" = 값의 크기가 큰 순서로 정렬 = ");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int val = (int) entry.getValue();
            System.out.println(entry.getKey() + " : " + printBar('#', val) + " " + val);
        }
    }

    static class ValueComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                Map.Entry e1 = (Map.Entry) o1;
                Map.Entry e2 = (Map.Entry) o2;

                int v1 = (int) e1.getValue();
                int v2 = (int) e2.getValue();
                return v2 - v1;
            }
            return -1;
        }
    }


    private static String printBar(char ch, int val) {
        char[] bar = new char[val];

        for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }
        return new String(bar);
    }
}
