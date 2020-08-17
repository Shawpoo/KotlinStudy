package com.shawpoo.java;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String aa = "nuai小图图";
        int i = 5;
        while (i > 0) {
            System.out.println(aa);
            i--;
        }
    }

    public void test() {
//        BookStore<EduBook> eduBookStore = new BookStore<>();
//        BookStore<Book> bookStore = eduBookStore;
    }

    class Book {

    }

    class EduBook extends Book {
    }

    class BookStore<T extends Book> {
    }


}
