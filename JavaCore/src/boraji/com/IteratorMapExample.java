package boraji.com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IteratorMapExample {
    public static void main(String[] args) {
        Map<String, String> daysMap = new HashMap<>();
        daysMap.put("1", "MON");
        daysMap.put("2", "TUE");
        daysMap.put("3", "WED");
        daysMap.put("4", "THU");
        daysMap.put("5", "FRI");
        daysMap.put("6", "SAT");
        daysMap.put("7", "SUN");

        /*Iterating map using Set Collection and Iterator*/
        System.out.println("Using Set and Iterator : ");
        Set<String> keysSet = daysMap.keySet();
        for (Iterator<String> stringIterator = keysSet.iterator(); stringIterator.hasNext();){
            String key = stringIterator.next();
            System.out.println("("+key+", "+daysMap.get(key)+")");
        }

        /*Iterating map using EntrySet and For-Each loop*/
        System.out.println("Using EntrySet and For-Each loop : ");
        Set<Map.Entry<String, String>> entries = daysMap.entrySet();
        for (Map.Entry<String, String> entry : entries){
            System.out.println("("+entry.getKey()+", "+entry.getValue()+")");
        }

        /*Iterating map using stream*/
        System.out.println("Using Stream : ");
        daysMap.forEach((key, value)-> System.out.println("("+key+", "+value+")"));
    }
}
