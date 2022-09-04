package Lambdademo;

public class ThreadDemo {
    public static void main(String[] args) {
        //First Thread : Thread - JOHN
        Runnable thread1 = () -> {
            //this is the body of thread
            //stuff
            for(int i = 1; i < 10; i++)
            {
                System.out.println("value of i " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(thread1, "JOHN");
        thread.start();
        System.out.println(thread.getName());

        Runnable runnable = () -> {
            try {
                for(int i = 1; i < 10; i++) {
                    System.out.println("Multiple of 2 " + 2 * i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread2 = new Thread(runnable, "thread2");
        thread2.start();
        System.out.println(thread2.getName());
    }
}
