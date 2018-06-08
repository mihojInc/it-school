package com.lessons.collection;

/**
 * New array of objects
 */
public class MyList implements IList {

    //Default array size is 16
    private Object[] objects = new Object[16];

    @Override
    public void add(Object o) {
        resize(size());
        for (int i = 0; i < objects.length; i++)
            if (objects[i] == null) {
                objects[i] = o;
                break;
            }
    }

    @Override
    public void add(int index, Object o) {
        resize(index);
        //check correct index
        if (index < objects.length & index > 0) {
            objects[index] = o;
        }
    }

    /**
     * Delete one object if it exist
     */
    @Override
    public boolean remove(Object o) {

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
        if (index < objects.length & index > 0) {
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
     * Return object by his index or null if it's d't exist
     */
    @Override
    public Object get(int index) {
        if (index < objects.length & index > 0) {
            return objects[index];
        }
        return null;
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
