public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        Multiplication multi = new Multiplication();
        for (int i = 0; i < 10; i++) {
            int count = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (count != 0) {
                        try {
                            threads[count - 1].join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    multi.multiplication(count + 1);
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

    }
}