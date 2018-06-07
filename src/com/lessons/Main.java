package com.lessons;

public class Main {

    public static void main(String[] args) {

        ObjectList objectList = new ObjectList();
        Books book1 = new Books("Book");
        Books book2 = new Books("Notebook");
        Books book3 = new Books("Textbook");
        Books book4 = new Books("Workbook");
        Books book5 = new Books("Newbook");
        Books book6 = new Books("Yourbook");
        Books book7 = new Books("Mybook");
        Books book8 = new Books("Goodbook");
        People person1 = new People("Tomas");
        People person2 = new People("Bob");
        People person4 = new People("Jane");
        People person5 = new People("Jhon");
        People person6 = new People("Artur");
        People person7 = new People("Kate");
        People person8 = new People("Yulia");

        objectList.addItemsToList(book1);
        objectList.addItemsToList(book2);
        objectList.addItemsToList(book3);
        objectList.addItemsToList(book4);
        objectList.addItemsToList(book7);
        objectList.addItemsToList(book8);

        objectList.fillItemList(12,book5);

        objectList.removeItemList(book4);

        objectList.removeItemByIndex(9);
        objectList.removeItemByIndex(2);

        objectList.itemsInList();

        System.out.println(objectList.getItemByIndex(4));

    }
}
