package ch12.enums;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0;
    int ordinal;
    String name = "";

    public int getOrdinal() {
        return ordinal;
    }

    MyEnum(String name) {
        this.name = name;
        ordinal = id++;
    }

    public int compareTo(T t) {
        return ordinal - t.getOrdinal();
    }
}

abstract class MyTransportation extends MyEnum {

    static final MyTransportation BUS = new MyTransportation("BUS", 100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    static final MyTransportation SHIP = new MyTransportation("SHIP", 100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 300) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };


    abstract int fare(int distance);

    protected final int BASIC_FARE;

    private MyTransportation(String name, int basicFare) {
        super(name);
        BASIC_FARE = basicFare;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}


public class EnumEx4 {
    public static void main(String[] args) {
        MyTransportation bus = MyTransportation.BUS;
        MyTransportation bus2 = MyTransportation.BUS;
        MyTransportation train = MyTransportation.TRAIN;
        MyTransportation ship = MyTransportation.SHIP;
        MyTransportation airplane = MyTransportation.AIRPLANE;


        System.out.println("bus = " + bus + ", " + bus.getOrdinal());
        System.out.println("bus2 = " + bus2 + ", " + bus2.getOrdinal());
        System.out.println("train = " + train + ", " + train.getOrdinal());
        System.out.println("ship = " + ship + ", " + ship.getOrdinal());
        System.out.println("airplane = " + airplane + ", " + airplane.getOrdinal());
        System.out.println("bus1==bus2 = " + (bus == bus2));
        System.out.println("bus.compareTo(train) = " + bus.compareTo(train));

    }
}
