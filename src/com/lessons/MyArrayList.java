package com.lessons;

/**
 * Create class MyArrayList
 */
public class MyArrayList implements Listable {
    //Fields
    private final Integer DEFAULT_CAPACITY = 16;
    private Object[] myList = new Object[DEFAULT_CAPACITY];
    private int size;

    /**
     * The method that adds an object to an array
     * @param o
     */
    @Override
    public void add(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == null) {
                myList[i] = o;
                size++;
                break;
            }
        }
        if (size > myList.length - 1) {
            increasingTheArray();
        }
    }

    /**
     * The method that adds an object to an array by index
     * @param index
     * @param o
     */
    @Override
    public void add(int index, Object o) {
        myList[index] = o;
        size++;
        if (size > myList.length - 1) {
            increasingTheArray();
        }
    }

    /**
     * The method that removes an object from an array
     * @param o
     */
    @Override
    public void remove(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == o) {
                myList[i] = null;
                size--;
                return;
            }
        }
    }

    /**
     * The method that removes an object from an array by index
     * @param index
     */
    @Override
    public void remove(int index) {
        if (index > myList.length) {
            myList[index] = null;
            size--;
        }
    }

    /**
     * The method that gets the object by index
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        return myList[index];
    }

    /**
     * The method that gets the size of the array
     * @return
     */
    @Override
    public Integer size() {
        return this.size;
    }

    /**
     * A method that increments an array if the place in it has run out
     */
    private void increasingTheArray() {
        Object[] newArray = new Object[myList.length * 2];
        System.arraycopy(myList, 0, newArray, 0, size);
        myList = newArray;

    }
}

