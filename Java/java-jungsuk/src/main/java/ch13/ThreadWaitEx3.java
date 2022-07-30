package ch13;


import java.util.ArrayList;

class Customer3 implements Runnable {
    private Table3 table3;
    private String food;

    public Customer3(Table3 table3, String food) {
        this.table3 = table3;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            String name = Thread.currentThread().getName();
            table3.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

class Cook3 implements Runnable {
    private Table3 table3;

    public Cook3(Table3 table3) {
        this.table3 = table3;
    }

    @Override
    public void run() {
        while (true) {
            int idx = (int) (Math.random() * table3.dishNum());
            table3.add(table3.dishNames[idx]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}

class Table3 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        if (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting");
            try {
                wait();
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
        dishes.add(dish);
        notify();
        System.out.println("Dishes : " + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();
            while (dishes.size() == 0) {
                System.out.println(name + " is waiting");
                try {
                    wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();
                        return;
                    }
                }
                try {
                    System.out.println(name + " is waiting");
                    wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public int dishNum() {
        return dishNames.length;
    }
}


public class ThreadWaitEx3 {
    public static void main(String[] args) throws InterruptedException {
        Table3 table3 = new Table3();

        new Thread(new Cook3(table3), "COOK1").start();
        new Thread(new Customer3(table3, "donut"), "CUST1").start();
        new Thread(new Customer3(table3, "burger"), "CUST2").start();

        Thread.sleep(2000);
        System.exit(0);


    }

}
