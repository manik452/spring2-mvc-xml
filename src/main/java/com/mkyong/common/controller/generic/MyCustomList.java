package com.mkyong.common.controller.generic;

import java.util.ArrayList;

public class MyCustomList {
    ArrayList<String> list = new ArrayList<String>();

    public void addElement(String element) {
        list.add(element);
    }

    public void removeElement(String element) {
        list.remove(element);
    }
}
