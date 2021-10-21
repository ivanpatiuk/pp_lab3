package laboratory3.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    static class Square implements Callable<Integer> {
        private int value;

        Square(int value) {
            this.value = value;
        }

        public Integer call() throws Exception {
            return value * value;
        }
    }

    static class MyThread extends Thread {
        private int value;

        public MyThread(final int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public void run() {
            System.out.println("Run for " + value);
            value = value * value;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] intArray = {1, 2, 3, 4, 5};
        MyThread myThread0 = new MyThread(intArray[0]);
        MyThread myThread1 = new MyThread(intArray[1]);
        MyThread myThread2 = new MyThread(intArray[2]);
        MyThread myThread3 = new MyThread(intArray[3]);
        MyThread myThread4 = new MyThread(intArray[4]);

        List<MyThread> list = new ArrayList<>();
        list.add(myThread0);
        list.add(myThread1);
        list.add(myThread2);
        list.add(myThread3);
        list.add(myThread4);

        myThread0.start();
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        System.out.println(list.stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList()));

        ExecutorService executor = Executors.newFixedThreadPool(3);
        System.out.println("\nAnother thread was executed");
        executor.execute(myThread0);
        executor.execute(myThread1);
        executor.execute(myThread2);

        System.out.println(list.stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList()));
        executor.shutdown();
        System.out.println("Finish");
    }
}
