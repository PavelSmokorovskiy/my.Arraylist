import myArrayList.MyArrayList;

import java.util.Arrays;

/**
 * Created by Smokorovskiy on 08.06.2016.
 */
public class TestArrayList {

    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 1; i <= 5; i++) {
            myArrayList.add(i);
        }
        System.out.println("My ArrayList created: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        myArrayList.add(11);
        System.out.println("add an element: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        myArrayList.add(2, 22);
        System.out.println("add an element by the index: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        myArrayList.addAll(myArrayList);
        System.out.println("addAll a collection: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        myArrayList.addAll(1, myArrayList);
        System.out.println("addAll a collection by the index: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        myArrayList.set(0, 888);
        System.out.println("set an element by the index: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        System.out.println("get an element by the index: " + myArrayList.get(0));
        myArrayList.remove(1);
        System.out.println("remove an element: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        myArrayList.remove((Integer) 1);
        System.out.println("remove an object: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        System.out.println("index of object (1): " + myArrayList.indexOf(1));
        myArrayList.clear();
        System.out.println("clear My ArrayList: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        myArrayList.add(0,22);
        myArrayList.add(11);
        System.out.println("My ArrayList add a collection by the index: " + Arrays.toString(myArrayList.toArray()) + " size = " + myArrayList.size());
        System.out.println("Is my ArrayList contains element?: " + myArrayList.contains(11));
        System.out.println("Is my ArrayList contains collection?: " + myArrayList.contains(myArrayList));


    }
}
