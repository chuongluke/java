package boraji.com;

import java.util.*;

public class DuplicateInArrayExample2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Two");
        list.add("two");
        list.add("Three");

        System.out.println("Before : " + list);

        Set<String> duplicateElements = new HashSet<>();

        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i - 1).equals(list.get(i))){
                duplicateElements.add(list.get(i));
            }
        }
        System.out.println("After : " + duplicateElements);

    }
}
