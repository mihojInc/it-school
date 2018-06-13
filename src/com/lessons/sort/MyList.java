package com.lessons.sort;

/**
 * New array of objects
 */
public class MyList<T> implements IList<T> {

    //Default array size is 16
    private Object[] objects = new Object[16];

    @Override
    public void add(T o) {
        resize(size());
        for (int i = 0; i < objects.length; i++)
            if (objects[i] == null) {
                objects[i] = o;
                break;
            }
    }

    @Override
    public void add(int index, T o) {
        resize(index);
        //check correct index
        if (index < objects.length & index >= 0) {
            objects[index] = o;
        }
    }

    /**
     * Delete one object if it exist
     */
    @Override
    public boolean remove(T o) {

        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(o)) {
                objects[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Set object = null by his index
     *
     * @return true if object delete or false if incorrect index
     */
    @Override
    public boolean remove(int index) {
        if (index < objects.length & index >= 0) {
            objects[index] = null;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        for (Object o : objects)
            if (o != null)
                count++;
        return count;
    }

    /**
     * Return type T object by his index or null if it's d't exist
     */
    @Override
    public T get(int index) {
        if (index < objects.length) {
            return (T) objects[index];
        }
        return null;
    }

    /**
     * Insert T object in to index position with shift
     *
     * @param index  position
     * @param object T object
     */
    public void insert(int index, T object) {

        if (index > this.size()) {
            this.add(index, object);
        } else {
            Object[] shiftedList = new Object[objects.length + 1];

            int i = 0;
            for (Object o : objects) {
                if (i != index) {
                    shiftedList[i] = o;
                    i++;
                } else {
                    shiftedList[i] = object;
                    shiftedList[++i] = o;
                    i++;
                }
            }
            objects = shiftedList;
        }
    }

    /**
     * Count length of array for his last exist object
     *
     * @return Integer index of last no null object
     */
    public Integer length() {
        int realSize = objects.length;
        if (realSize != 0)
            while (objects[--realSize] == null) ;

        return realSize;
    }

    /**
     * Resize object array by his size * 2 if main array is full
     */
    private void resize(int index) {
        if (objects.length <= index) {
            Object[] resizebleArray = new Object[(index * 2) - 2];
            for (int i = 0; i < size(); i++) {
                resizebleArray[i] = objects[i];
            }
            objects = resizebleArray;
        }
    }
}
