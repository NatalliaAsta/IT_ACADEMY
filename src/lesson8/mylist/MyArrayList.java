package lesson8.mylist;

import java.util.Collection;

public class MyArrayList<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 3;

    public static final Object[] EMPTY_T = new Object[0];
    private int size;

    T[] startArray;

    private void increaseDefaultCapacity() {
        int capacity;
        if (size == 0) {
            capacity = DEFAULT_CAPACITY;
        } else {
            capacity  = size * 2;
        }
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = startArray[i];
            startArray[i] = null;
        }
        startArray = (T[]) newArray;
    }

    private void delElementAndShiftToLeft(int startPos) {
        size--;
        if (size <= 0) {
            return;
        }
        if (size != startPos) {
            System.arraycopy(startArray, startPos + 1, startArray, startPos, size - startPos);
        }
        startArray[size] = null;
    }

    public MyArrayList() {
        startArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            startArray = (T[]) new Object[capacity];
        } else {
            startArray = (T[]) EMPTY_T;
        }
    }

    /* Создает список, в который добавляются все элементы коллекции col */
    public MyArrayList(MyList<? extends T> col) {
        startArray = (T[]) new Object[col.size()];
        for (int i = 0; i < col.size(); i++) {
            startArray[i] = col.get(i);
        }
    }

    /* Возвращает количество элементов в коллекции */
    @Override
    public int size() {
        return size;
    }

    /* Проверяет на наличие элементов в коллекции */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /* Проверяет, содержится ли заданный элемент в коллекции */
    @Override
    public boolean contains(Object value) {
        if (value != null) {
            for (int i = 0; i < startArray.length; i++) {
                if (value.equals(startArray[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Добавляет элемент в конец списка */
    @Override
    public boolean add(T value) {
        if (size >= startArray.length) {
            increaseDefaultCapacity();
        }
        startArray[size++] = value;
        return true;
    }

    /* Добавляет в список по индексу index объект value*/
    @Override
    public boolean add(int index, T value) {
        if (index < 0) {
            return false;
        }
        if (size + 1 >= startArray.length) {
            increaseDefaultCapacity();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i >= index; i--) {
            startArray[i + 1] = startArray[i];
        }
        startArray[index] = value;
        size++;
        return true;
    }

    /* Удаляет объект value из списка, если он там имеется */
    @Override
    public boolean remove(Object value) {
        if (value != null) {
            for (int i = 0; i < startArray.length; i++) {
                if (value.equals(startArray[i])) {
                    delElementAndShiftToLeft(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> value) {
        T[] incoming = (T[]) value.toArray();
        T[] newArray = (T[]) new Object[size + value.size()];
        for (int i = 0; i < size; i++) {
            newArray[i] = startArray[i];
            startArray[i] = null;
        }

        for (int i = size; i < (size +incoming.length); i++) {
            newArray[i] = incoming[i-size];
            incoming[i-size] = null;
        }
        startArray = (T[]) newArray;
        return true;
    }

    /* Возвращает объект из списка по индексу */
    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return startArray[index];
    }

    /* Удаляет элемент по индексу, возвращает при этом удаленный объект */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T delElement;
        delElement = startArray[index];
        delElementAndShiftToLeft(index);
        return delElement;
    }

    /* Присваивает значение бъектка value элементу с индексом index*/
    @Override
    public T set(int index, T value) {
        if (index < 0) {
            return null;
        }
        if (index >= size) {
            index = size;
            add(index, value);
        }
        startArray[index] = value;
        return value;
    }

    /* Возвращает индекс первого вхождения элемента value в списке */
    @Override
    public int indexOf(Object value) {
        if (value != null) {
            for (int i = 0; i < size; i++) {
                if (value.equals(startArray[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}
