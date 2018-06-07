package com.lessons;

public class MyList {

    private Object[] myList = new Object[16];

    private int count = 0;

    private void increaseSize() {
        Object[] myList2 = new Object[myList.length * 2];
        for (int i = 0; i < myList.length; i++) {
            myList2[i] = myList[i];
        }
        this.myList = myList2;
    }

    public void add(Object o) {
        analizeSize();
        if (count == 0) {
            myList[0] = o;
            ++count;
        } else {
            for (int i = 0; i < myList.length; i++) {
                if (myList[i] == null) {
                    myList[i] = o;
                    ++count;
                    break;

                }
            }
        }
    }

    private void analizeSize() {
        if (count == myList.length) {
            increaseSize();
        }
    }

    public void add(int idx, Object o) {
        if (idx > myList.length) {
            analizeSize();
        }
        myList[idx] = o;


    }

    public void remove(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == o) {
                myList[i] = null;
                count--;
                return;
            }
        }
    }

    public void remove(int idx) {
        if (idx < myList.length) {
            myList[idx] = 0;
        }



    }

    public Object get(int idx) {
        if (idx < myList.length) {
            return myList[idx];
        }
        else return null;
    }

    public Integer size() {
        return myList.length;

    }

    public Integer count() {
        return count;
    }
}
