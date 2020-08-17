package com.shawpoo.java;

public class LambdaTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111111111");
            }
        }).start();

        new Thread(() -> System.out.println("222222222222")).start();
    }

}
