package boraji.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateFromList1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Six");

        System.out.println("Before : " + list);
        Set<String> set = new HashSet<>();
        for (String string : list){
            set.add(string);
        }
        System.out.println("After : " + set);

    }
}
