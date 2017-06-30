package myArrayList;

import java.util.*;

/**
 * Created by Smokorovskiy on 07.06.2016.
 */

public class MyArrayList<E> implements MyList<E> {

    //Stores the elements
    private E[] array;

    //The size of the myArrayList. Keeps track of the number of array.
    private int size;

    //Default initial capacity
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.array = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        E[] copy = Arrays.copyOf(array, size);
        return Arrays.asList(copy).iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    //makes array bigger on given capacity
    private void grow(int capacity) {
        array = Arrays.copyOf(array, array.length + capacity + 1);
    }

    @Override
    public boolean add(E element) {
        if (size >= array.length) {
            grow(1);
        }
        array[size++] = element;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E element : collection) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
        grow(size + collection.size());
        System.arraycopy(array, index, array, index + collection.size(), size - index);
        System.arraycopy(collection.toArray(), 0, array, index, collection.size());
        size += collection.size();
        return true;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    //Why this method in JDK is not void?
    @Override
    public E set(int index, E element) {
        return array[index] = element;
    }

    @Override
    public boolean remove(Object object) {
        remove(indexOf(object));
        return true;
    }

    @Override
    public E remove(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return array[index];
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    //Method don't work. TODO: Find out the problem
    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection)
            if (contains(element))
                return true;
        return false;
    }

    //TODO: Fill this methods
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }



}
