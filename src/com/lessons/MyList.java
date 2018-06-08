package com.lessons;

public class MyList {
    private Object[] list = new Object[16];
    private int count = 0;

    public void add(Object o){
        if(count>list.length-1){
            makeBigger(count);
        }
        for(int i = 0; i<list.length; i++){
            if(list[i] == null){
                list[i] = o;
                count++;
                break;
            }
        }
    }

    public void add(int idx, Object o){
        if(idx>list.length-1){
            makeBigger(idx);
        }
        list[idx] = o;
        count++;
    }

    public void remove(Object o){
        for(int i = 0; i<list.length; i++){
            if(list[i] == o){
                list[i] = null;
                count--;
                break;
            }
        }
    }

    public void remove(int idx){
        if(idx>list.length){
            return;
        }
        list[idx] = null;
        count--;
    }

    public Object get(int idx){
        if(idx>list.length){
            return null;
        }
        return list[idx];
    }

    public Integer size(){
        int size = 0;
        for(int i = 0; i<list.length; i++){
            if(list[i] != null){
                size++;
            }
        }
        return size;
    }
    private void makeBigger(int num){
        Object[] newList = new Object[num*2];
        for(int i = 0; i<list.length; i++){
            newList[i] = list[i];
        }
        list = newList;
    }
}
