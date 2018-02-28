package boraji.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateFromList2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Three");

        System.out.println("Before : " + list);
        Set<String> set = new HashSet<>(list);
        System.out.println("After : " + set);
    }

}
