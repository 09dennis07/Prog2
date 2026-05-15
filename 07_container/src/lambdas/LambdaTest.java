package lambdas;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

class IntArrayUtils {
    public static void forEach(int[] array, IntConsumer consumer) {
        for (int i: array) {
            consumer.accept(i);
        }
    }
    
    public static void forEachIf(int[] array, IntPredicate predicate, IntConsumer consumer) {
        for (int value: array) {
            if (predicate.test(value))
            consumer.accept(value);
        }
    }
}

public class LambdaTest {

    public static void main(String[] args) {
        int[] array = {1,2,3};
        IntArrayUtils.forEach(array, new IntConsumer(){
            @Override
            public void accept(int value) {
                System.out.println(value);          
            }
        });
        System.out.println("finished 1");

        IntArrayUtils.forEach(array, i -> System.out.println(i));
        System.out.println("finished 2");

        IntArrayUtils.forEach(array, i -> { if (i%2 == 0) System.out.println(i);});
        System.out.println("finished 3");

        IntConsumer printIfOdd = i -> { if (i%2 != 0) System.out.println(i);};
        IntArrayUtils.forEach(array,printIfOdd);
        System.out.println("finished 4");

        IntArrayUtils.forEachIf(array, i -> i%2 == 0, i -> System.out.println(i) );
        System.out.println("finished 5");

        //function and constructor references
        IntArrayUtils.forEach(array, System.out::println);
        System.out.println("finished 6");
    }

}
