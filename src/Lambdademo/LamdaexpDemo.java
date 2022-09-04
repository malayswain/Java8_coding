package Lambdademo;

public class LamdaexpDemo {
    public static void main(String[] args) {
        System.out.println("my system starts....");
//        MyInterface myInterface = new MyInter();
//        myInterface.SayHello();
//        MyInterface myInterface1 = new MyInterface() {
//            @Override
//            public void SayHello() {
//                System.out.println("I am myinterface anonumyous or inner class");
//            }
//        };
//        myInterface1.SayHello();
//
//        MyInterface myInterface2 = new MyInterface() {
//            @Override
//            public void SayHello() {
//                System.out.println("this is second anonumyous class of same MyInterface");
//            }
//        };
//        myInterface2.SayHello();

        //using our functional interface with help of lambda

//        MyInterface myInterface = () -> System.out.println("My first lambda expression");
//        myInterface.SayHello();
//        MyInterface myInterface1 = () -> System.out.println("Second lambda expression");
//        myInterface1.SayHello();

//          AdditionLambdaDemo add = (a,b) -> (a+b);
//          System.out.println(add.Add(4,5));
//          System.out.println(add.Add(5,98));
//          AdditionLambdaDemo add1 = (a,b) -> {
//            return a+b;
//          };
//        System.out.println(add1.Add(9,2));

        LengthInter display = (name) -> name;
        System.out.println("NAME:- " + display.Print("My name is malay"));
        ShowLength sl = len -> len.length();
        System.out.println("name "+ sl.getLength("hello malay"));


    }
}
