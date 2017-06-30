package myArrayList;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Smokorovskiy on 14.06.2016.
 */
public interface MyList<E> extends Collection<E> {

    int size();

    Iterator<E> iterator();

    Object[] toArray();

    boolean add(E element);

    void add(int index, E element);

    boolean addAll(Collection<? extends E> collection);

    boolean addAll(int index, Collection<? extends E> collection);

    E get(int index);

    E set(int index, E element);

    E remove(int index);


}
