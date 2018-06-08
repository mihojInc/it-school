package com.lessons;

/**
 * Class describe list of goods wich wich have in the shop
 */
public class MyList {


    /**
     * List of goods wich conteins goods
     */
    private Object[] myList = new Object[16];

    /**
     * Current count goods in the list
     */
    private int count = 0;

    /**
     * This procedure increase size of the array if array is full
     */
    private void increaseSize() {
        Object[] myList2 = new Object[myList.length * 2];
        for (int i = 0; i < myList.length; i++) {
            myList2[i] = myList[i];
        }
        this.myList = myList2;
    }
    /**
     * This procedure shrinc size of the array if array is half empty
     */
    private void shrinkSize(){
        Object[] myList2 = new Object[myList.length / 2];
        int n = 0;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i]!=null){
                myList2[n++] = myList[i];
            }
        }
        this.myList = myList2;
    }

    /**
     * procedure add object in the list
     * @param o object wich we add in the list
     */
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

    /**
     * procedure add object in the list in the
     * @param o object wich we add in the list
     * @param idx slot where we will add new object
     */
    public void add(int idx, Object o) {
        if (idx > myList.length) {
            analizeSize();
        }
        myList[idx] = o;
    }

    /**
     * analize if the array is full
     */
    private void analizeSize() {
        if (count == myList.length) {
            increaseSize();
        }
        if (count == myList.length/2) {
            shrinkSize();
        }
    }

    /**
     *
     * @param o removable object
     */
    public void remove(Object o) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == o) {
                myList[i] = null;
                count--;
                return;
            }
        }
        analizeSize();
    }

    /**
     *
     * @param idx index removable object
     */
    public void remove(int idx) {
        if (idx < myList.length) {
            myList[idx] = 0;
        }
        analizeSize();
    }

    /**
     *
     * @param idx index of the object
     * @return object in placce of idx index if thera is no object return null
     */
    public Object get(int idx) {
        if (idx < myList.length) {
            return myList[idx];
        }
        else return null;
    }

    /**
     *
     * @return size of array
     */
    public Integer size() {
        return myList.length;

    }

    /**
     *
     * @return count objects in the array
     */
    public Integer count() {
        return count;
    }

    /**
     * out to console list of goods in the array
     */
    public void getList() {
        com.lessons.Goods ts;
        for (int i = 0; i <= myList.length; i++) {

            if (myList[i] != null){

                ts = (com.lessons.Goods)myList[i];
                System.out.println("Cur pos " + (i+1) + " Name " + ts.getName() +
                        " price " + ts.getPrice() +
                        " cost " + ts.getPrice());
            }else
                System.out.println("Cur pos " + (i+1) + " null");

        }

    }
}
