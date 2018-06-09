package lesson4.phop;

public interface MyList {

    //добавить элем в список
    void add (Object object);

    //заполнить конкретную ячеуку
    void add (int idx, Object object);

    //находит удаляет переданый объект в списке
    void remove (Object object);

    //очищает ячейку с указаным индексом
    void remove (int idx);


    //возвращает елемент из списка по индексу
    Object get (int idx);

    // количество заполненых ячеек в списке(не размер)
    Integer size ();

}
