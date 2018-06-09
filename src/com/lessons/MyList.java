package com.lessons;

public interface MyList {
    //MyList [] myList = new MyList[16];



    void add(Object o);
    void add(int idx, Object o);
    void remove(Object o);
    void remove (int idx);
    Object get (int idx);
    Integer size();
}
