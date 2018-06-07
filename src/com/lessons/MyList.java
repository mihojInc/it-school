package com.lessons;

public interface MyList {
    /**
     * This interface contains several methods for managing array of random Items.
     */

    /**
     * This method add one item to the array
     * @param object
     */
    void addItemsToList (Items object);

    /**
     *This method describes how to place an object into particular point in the array.
     * @param Index
     * @param object
     */
    void fillItemList (int Index, Items object);

    /**
     * This method describes how to find particular object in the array and remove it.
     * @param object
     */
    void removeItemList (Object object);

    /**
     * This method describes how to clear place in the array with particular index.
     * @param index
     */
    void removeItemByIndex (int index);

    /**
     * This method describes how to show element in the array by it's index.
     * @param index
     * @return
     */
    Object getItemByIndex (int index);


    /**
     * This method describes how to show number of items that have been placed in the array.
     * @return
     */
    Integer itemsInList ();
}
