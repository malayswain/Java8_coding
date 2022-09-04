package Lambdademo;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable runs = () -> {
            System.out.println("first thread");
        };
        Thread thread = new Thread(runs, "newthread");
        thread.start();
    }
}
