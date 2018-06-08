package com.lessons;

public interface Listable {

    void add(Object o);

    void add(int index, Object o);

    void remove(Object o);

    void remove(int index);

    Object get(int index);

    Integer size();

}
