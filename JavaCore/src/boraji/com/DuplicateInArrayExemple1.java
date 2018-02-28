package boraji.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateInArrayExemple1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Two");
        list.add("Three");
        list.add("Three");
        list.add("Four");
        System.out.println("Before : " + list);
        Set<String> set = new HashSet<>();
        Set<String> duplicateElements = new HashSet<>();

        for( String elm : list){
            if(!set.add(elm)){
                duplicateElements.add(elm);
            }
        }

        System.out.println("After : " + duplicateElements);
    }
}
