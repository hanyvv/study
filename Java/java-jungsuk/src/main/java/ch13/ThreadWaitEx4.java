package ch13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Customer4 implements Runnable {
    private Table4 table4;
    private String food;

    public Customer4(Table4 table4, String food) {
        this.table4 = table4;
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
            table4.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

class Cook4 implements Runnable {
    private Table4 table4;

    public Cook4(Table4 table4) {
        this.table4 = table4;
    }

    @Override
    public void run() {
        while (true) {
            int idx = (int) (Math.random() * table4.dishNum());
            table4.add(table4.dishNames[idx]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Table4 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private List<String> dishes = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();

    public void add(String dish) {
        lock.lock();

        try {
            while (dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {
                    forCook.await();
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                }
            }
            dishes.add(dish);
            forCust.signal();
            System.out.println("Dishes : " + dishes.toString());
        } finally {
            lock.unlock();
        }
    }

    public void remove(String dishName) {
        lock.lock();
        String name = Thread.currentThread().getName();

        try {
            while (dishes.size() == 0) {
                System.out.println(name + " is waiting");
                try {
                    forCust.await();
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }

            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        forCook.signal();
                        return;
                    }
                }
                try {
                    System.out.println(name + " is waiting.");
                    forCust.await();
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        } finally {
            lock.unlock();
        }
    }

    public int dishNum() {
        return dishNames.length;
    }
}

public class ThreadWaitEx4 {
    public static void main(String[] args) throws InterruptedException {
        Table4 table4 = new Table4();
        new Thread(new Cook4(table4), "COOK1").start();
        new Thread(new Customer4(table4, "donut"), "CUST1").start();
        new Thread(new Customer4(table4, "burger"), "CUST2").start();

        Thread.sleep (2000);
        System.exit(0);
    }
}
