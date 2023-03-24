import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("enter Number 1 to choose  Multiplication by reentrant lock or \nNumber 2  to choose  Multiplication by Synchronized");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> {
                System.out.println("Multiplication With Reentrant lock");
                Thread[] thread1 = new Thread[10];
                MultiplicationWithReentrant multi = new MultiplicationWithReentrant();
                for (int i = 0; i < 10; i++) {
                    int count = i;
                    thread1[i] = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if (count != 0) {
                                try {
                                    thread1[count - 1].join();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            multi.multiplicationWithReentrant(count + 1);
                        }
                    });
                }
                for (int i = 0; i < 10; i++) {
                    thread1[i].start();
                }
            }
            case 2 -> {
                System.out.println("Multiplication With Synchronized");
                Thread[] thread2 = new Thread[10];
                MultiplicationWithSynchronized multiplicationWithSynchronized = new MultiplicationWithSynchronized();
                for (int i = 0; i < 10; i++) {
                    int count = i;
                    thread2[i] = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if (count != 0) {
                                try {
                                    thread2[count - 1].join();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            multiplicationWithSynchronized.multiplication(count + 1);
                        }
                    });
                }
                for (int i = 0; i < 10; i++) {
                    thread2[i].start();
                }
            }
            default -> System.out.println("please choose between number 1 or number 2");
        }
    }
}