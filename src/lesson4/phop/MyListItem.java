package lesson4.phop;

public class MyListItem implements MyList {

    private Object[] list = new Object[16];
    private int count =0;

    //добавить элем в список
    @Override
    public void add(Object object) {
        if (count > list.length -1){
            newList(count);}
        for (int i = 0; i<list.length; i++){
            if (list[i]== null){
                list[i] = object;
                count++;
                break;
            }
        }
    }

    //заполнить конкретную ячеуку
    @Override
    public void add(int idx, Object object) {
        if (idx > list.length -1){
            newList(idx);
        }
        list[idx] = object;
        count++;
    }


    //находит удаляет переданый объект в списке
    @Override
    public void remove(Object object) {
        for (int i= 0;i<list.length; i++){
            if ( list[i] == object){
                list[i]= null;
                count--;
                break;
            }
        }

    }

    //очищает ячейку с указаным индексом
    @Override
    public void remove(int idx) {
        if(idx > list.length){
            return;
        }
        list[idx]=null;
        count--;
    }

    //возвращает елемент из списка по индексу
    @Override
    public Object get(int idx) {
        if(idx>list.length){
            return null;
        }
        return list[idx];
    }

    // количество заполненых ячеек в списке(не размер)
    @Override
    public Integer size() {
        int size = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                size++;
            }
        }
        return size;
    }

    // создаем увеличеный массив в 2 раза и присваиваем значения с первого
    private void newList (int number){
        Object [] newList = new Object[number *2 ];
        for (int i =0; i< list.length; i++ ){
            newList[i] = list[i];
        }
        newList =list;
    }
}

