package Lesson_4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dm.Petrov
 * DATE: 08.12.2021
 */
public class Main {
    public static void main(String[] args) {
        //              1. Find index
        Search sL = (n, list) -> Arrays.asList(list).indexOf(n);
        System.out.println(sL.search(2, new Integer[]{1, 2, 5}));
        //              2. String reverse
        StringReverse rev = (String s) -> new StringBuilder(s).reverse().toString();
        System.out.println(rev.reverse("Interfaces"));
        //               3. Find maximum
        System.out.println(maximum(new Integer[]{1, 4, 44, 8, 13}));
        //               4. Find average
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(10);
        list.add(21);
        System.out.println(average(list));
        //              5. String start with 'a'
        List<String> list2 = new ArrayList<>();
        list2.add("alf");
        list2.add("it");
        list2.add("Around");
        list2.add("amo");
        System.out.println(search(list2));
    }

   public static Integer maximum(Integer[] list){
       List<Integer> numbers = Arrays.asList(list);
       Optional<Integer> max = numbers.stream().max((x, y) -> Integer.compare(x, y));
       return max.get();
   }
    public static Double average(List<Integer> list){
      return  list.stream().mapToInt(e -> e).average().getAsDouble();
    }
    public static List<String> search(List<String> list){
        return  list.stream().filter(s->s.startsWith("a")).filter(s->s.length()==3).collect(Collectors.toList());
    }

}