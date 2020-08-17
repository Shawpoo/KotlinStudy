package com.shawpoo.java;

import com.shawpoo.kotlin.singleton.Singleton;

public class SingletonTest {

    public static void main(String[] args) {
        System.out.println(Singleton.x);
        Singleton.INSTANCE.y();
    }

}
