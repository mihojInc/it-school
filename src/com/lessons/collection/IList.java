package com.lessons.collection;

/**
 * For create some array with any Objects
 */
public interface IList {

    /**
     * Add
     *
     * @param o Object to the first free space of array, biggest to the size*2 if array is full
     */
    void add(Object o);

    /**
     * Overwrite
     *
     * @param index position
     * @param o     Object.
     */
    void add(int index, Object o);

    /**
     * Delete Object from array
     * @return true if o is exist
     */
    boolean remove(Object o);

    /**
     * Delete Object by his index
     */
    boolean remove(int index);

    /**
     * Return count of exist Object
     */
    int size();

    /**
     * Get object by his index
     */
    Object get(int index);

}
