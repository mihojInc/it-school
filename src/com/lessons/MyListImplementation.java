package com.lessons;

public class MyListImplementation implements MyList {
    private Object [] myList= new Object[16];;
    private int size= 0;



    @Override
    public void add(Object o) {
       if(size == myList.length){
           listGrowing();
       }
       myList[size] = o;
       size++;
    }

    @Override
    public void add(int idx, Object o) {
        if(size == myList.length){
            listGrowing();
        }
        /**
         * We increase the number of items in the list only if we add a new element,
         * and not just replace the previous one
         */
        if(myList[idx] == null){size++;}
        myList[size]=o;
    }

    @Override
    public void remove(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i].equals(o)) {
                myList[i] = null;
                size--;
                break;
            }
        }

    }

    @Override
    public void remove(int idx) {
        for (int i = idx; i < myList.length-1; i++) {
            myList[i] = myList[i + 1];
        }
        size--;


    }

    @Override
    public Object get(int idx) {
        return myList[idx];
    }

    @Override
    public Integer size() {
        return size;
    }

    private void listGrowing(){
        Object [] myList1 = new Object[myList.length*2];
        for(int i = 0; i < myList.length; i++){
            myList1[i]=myList[i];
        }
        myList = myList1;
    }

}
