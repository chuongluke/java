package boraji.com;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class IterateListExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(new Integer[]{1,2,3,4,5,6});
        /*Basic for loop*/
        System.out.println("Basic for loop : ");
        for(int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + "\t");
        }
        /*For-Each loop*/
        System.out.println("For-Each loop : ");
        for(Integer i : numbers){
            System.out.print(i + "\t");
        }
        /*Using Iterator*/
        System.out.println("Using Iterator");
        for (ListIterator<Integer> listIterator = numbers.listIterator(); listIterator.hasNext();){
            System.out.println(listIterator.next() + "\t");
        }
        /*Using Stream*/
        System.out.println("Using stream");
        numbers.stream().forEach(e-> System.out.print(e + "\t"));
    }
}
