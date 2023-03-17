public class Multiplication {
    final Object object = new Object();
    public  void multiplication (int x){
            synchronized (object) {
                System.out.println("multiplication of number "+ x);
                for (int i = 1; i <=10; i++) {
                    System.out.print(x * i +"   " );
                }
                System.out.println();
            }
    }
}
