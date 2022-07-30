package ch13;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {
    public static void main(String[] args) {
        ThreadEx11_1 t1 = new ThreadEx11_1("Thread1");
        ThreadEx11_2 t2 = new ThreadEx11_2("Thread2");
        t1.start();
        t2.start();
    }
}

class ThreadEx11_1 extends Thread {
    public ThreadEx11_1(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
        }
    }
}

class ThreadEx11_2 extends Thread {
    public ThreadEx11_2(String name) {
        super(name);
    }

    @Override
    public void run() {
        Map<Thread, StackTraceElement[]> map = getAllStackTraces();
        Iterator<Thread> iterator = map.keySet().iterator();

        int x = 0;
        while (iterator.hasNext()) {
            Thread thread = iterator.next();
            StackTraceElement[] ste = map.get(thread);

            System.out.println("[" + ++x + "] name : " +thread.getName() + ", group : "
                    +thread.getThreadGroup().getName() + ", daemon : " + thread.isDaemon());
            for (int i = 0; i < ste.length; i++) {
                System.out.println(ste[i]);
            }
            System.out.println();
        }
    }
}
