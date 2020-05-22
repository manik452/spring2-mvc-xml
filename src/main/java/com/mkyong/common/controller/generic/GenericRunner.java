package com.mkyong.common.controller.generic;

public class GenericRunner {

    private static void p(Object o) {
        System.out.println(o);
        return;
    }

    public static void main(String[] agr) {
        p("Hello");

        MyCustomList list = new MyCustomList();
    }
}
