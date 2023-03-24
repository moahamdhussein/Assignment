import java.util.concurrent.locks.ReentrantLock;

public class MultiplicationWithReentrant {

    public  void multiplicationWithReentrant (int x){
        ReentrantLock lock  =new ReentrantLock();
        lock.lock();
            System.out.println("multiplication of number "+ x);
            for (int i = 1; i <=10; i++) {
                System.out.print(x * i +"   " );
            }
            System.out.println();
        lock.unlock();
    }
}
