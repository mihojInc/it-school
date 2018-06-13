package com.lessons.sort;

/**
 * For create some array with any Objects
 */
public interface IList<T> {

    /**
     * Add
     *
     * @param o Object to the first free space of array, biggest to the size*2 if array is full
     */
    void add(T o);

    /**
     * Overwrite
     *
     * @param index position
     * @param o     Object.
     */
    void add(int index, T o);

    /**
     * Delete Object from array
     * @return true if o is exist
     */
    boolean remove(T o);

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
