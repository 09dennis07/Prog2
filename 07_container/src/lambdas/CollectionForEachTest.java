package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionForEachTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList( 8, 13, 1, 35, 4 );
        list.forEach( i -> System.out.print(" " + i));
        System.out.println();
        
        list.sort((i,j) -> i.compareTo(j));
        list.forEach( i -> System.out.print(" " + i));
        System.out.println();
        
        List<Integer> list2 = new ArrayList<Integer>(list);
        list2.removeIf(i -> i%2 == 0);
        list2.forEach( i -> System.out.print(" " + i));
        System.out.println();
    }
}
