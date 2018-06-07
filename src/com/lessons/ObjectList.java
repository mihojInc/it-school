package com.lessons;

import java.util.Arrays;

public class ObjectList implements MyList {

    Items[] objectLists = new Items[16];
    int countItems = 0;

    @Override
    public void addItemsToList(Items object) {
        for (int i = 0; i < objectLists.length; i++) {
            if (objectLists[i] == null) {
                if (countItems < 15) {
                    objectLists[i] = object;
                    countItems++;
                    System.out.println("Item has been added ");
                    break;
                } else {
                    countItems++;
                    objectLists = Arrays.copyOf(objectLists, objectLists.length * 2);
                    break;
                }
            }
        }
    }

    @Override
    public void fillItemList(int index, Items object) {
        objectLists[index] = object;
        System.out.println("The object has been added by index ");
    }


    @Override
    public void removeItemList(Object object) {
        for (int i = 0; i < objectLists.length; i++) {
            if (objectLists[i] != null && objectLists[i].equals(object)) {
                objectLists[i] = null;
                System.out.println("This object has been removed by name");
                break;
            }
        }
    }

    @Override
    public void removeItemByIndex(int index) {
        if (objectLists[index] != null) {
            objectLists[index] = null;
            System.out.println("Object with index " + index + " has been removed");
        } else {
            System.out.println("This index does not have an object");
        }
    }

    @Override
    public Object getItemByIndex(int index) {
        if (objectLists[index] != null) {
            return objectLists[index].getName();
        } else {
            return null;
        }
    }


    @Override
    public Integer itemsInList() {
        System.out.println("The number of objects in the array is " + countItems);
        return countItems;
    }

}
