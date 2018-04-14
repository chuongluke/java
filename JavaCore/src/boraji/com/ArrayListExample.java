package boraji.com;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("Four");
        list.add("five");
        System.out.println("Element in list : " + list);

        /*Remove an element from the list*/
        String removeEle = list.remove(0);
        System.out.println("Element remove : " + removeEle);
        System.out.println("Element in list after removed : " + list);

        /*Retrieving an element in the list*/
        String element = list.get(1); //Second element
        System.out.println("Element at second position : " + element);

        /*Print size of list*/
        System.out.println("Size of the list : " + list.size());

        /*Check if an element exist in the list*/
        System.out.println("Element exist : " + list.contains("five"));

        /*Finding the index of an element*/
        System.out.println("Index of 'four' is : " + list.indexOf("four"));

        /*Removing all element from the list*/
        list.clear();
        System.out.println("Element in list : " + list);
    }
}
