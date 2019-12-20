package com.example.demo;

public class Test  implements  Runnable {
    private String hello;

    public Test(String hello) {
        this.hello = hello;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hello);
    }

    public static void main(String[] args) {
        (new Thread(new Test("你好"))).start();
    }
}
