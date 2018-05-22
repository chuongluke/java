package boraji.com;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.println("Element of the list : " + list);

        /*Remove an element from linked list*/
        String removeElement = list.remove(0);
        System.out.println("Element removed : " + removeElement);
        System.out.println("Element of list after removed : " + list);

        /*Retrieving an element in the linked list*/
        String element = list.get(1);
        System.out.println("Element at second posision : " + element);


        /*Print size of linked list*/
        System.out.println("Size of linked list : " + list.size());

        /*Check if an element exist in the linked list*/
        System.out.println("Element existed : " + list.contains("Five"));

        /*Findding the index of an element*/
        System.out.println("Index of 'Four' in the linked list : " + list.indexOf("Four"));

        /*Removing all element in the linked list*/
        list.clear();
        System.out.println("Element in the linked list : " + list);
    }
}
