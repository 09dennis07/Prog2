package lambdas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {
    
    // assumes that n is 2 or odd
    public static boolean isPrime(int n) {
        if (n==2)
            return true;
        if (n<2) 
            return false;
        if (n%2==0)
            return false;
        for (int i= 3; i <= n/2; i+=2)
            if (n%i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        // source data structures
        int[] intArray = { 9, 17, 1, 2, 36, 3 };
        List<List<Integer>> doubleIntList = Arrays.asList(
        		  Arrays.asList(1, 2, 3), 
        		  Arrays.asList(4, 5, 6), 
        		  Arrays.asList(7, 8, 9)
        		); // [ [ 1, 2, 3] , [4, 5, 6], [7,8,9]]
        List<Integer> integerList = Arrays.asList( 8, 13, 1, 2, 35, 4 );
        List<String> stringList = Arrays.asList( "hello world", "good bye" );
        String string = "to be or not to be is the question to be answered";
        
        // intermediate function filter and terminal function count
       long count = integerList.stream().filter(n -> (n > 1) && ((n==2) || (n % 2) != 0))
                                 .filter(n -> isPrime(n))
                                 .count();  // alt. reduce(0,(i,j) -> i+1)
        System.out.println(count + " primes found");
        System.out.println();
        
        // sort and map
        integerList.stream().sorted()                 // type Stream<Integer>  
                     .map(n -> n + ":" + isPrime(n))  // type Stream<String>  
                     .forEach(s -> System.out.println(s));
        System.out.println();
        
        // result of type Optional
        Optional<Integer> primeOptional = integerList.stream().filter(n -> isPrime(n))
                                                              .findAny();
        if (primeOptional.isPresent())
            System.out.println("found prime: " + primeOptional.get());
        else 
            System.out.println("no prime in list");
        System.out.println();
        
        // work directly on arrays
        Arrays.stream(intArray) // is of type IntStream
                               .sorted()
                               .mapToObj(n -> n + ":" + isPrime(n)) // type Stream<String>
                                .forEach(s -> System.out.println(s));
        System.out.println();
        
        // map reduce pattern
        int sumOfSquares = integerList.stream().map(i -> i * i)
                                               .reduce(0, (i,j) -> i + j);
        System.out.println("sum of the squares: " + sumOfSquares);
        System.out.println();
        
        int charCount = stringList.stream().mapToInt(s -> s.length())
                                           .reduce(0, (i,j) -> i+j);
        System.out.println("number of characters: " + charCount);
        // alt. by specialized reduction function
        charCount = stringList.stream().mapToInt(s -> s.length())
                                       .sum();
        System.out.println("number of characters: " + charCount);
        
        System.out.println();
        String upperCaseText = stringList.stream().map(s -> s.toUpperCase())
                                                  .reduce("", (s,t) -> s + " " + t);
        System.out.println("uppercase text: " + upperCaseText);
        System.out.println();
        
        // collect as mutable reduction
        Map<String,Integer> wordCountMap = Arrays.asList(string.split(" ")).stream()
                .collect(HashMap<String,Integer>::new,
                        (HashMap<String,Integer> map,String s) -> { 
                           Integer i = map.get(s); 
                           if (i == null) map.put(s,1); else map.put(s,i+1);
                        }, 
                        (map1,map2) -> map1.putAll(map2));
        System.out.println("word count: " + wordCountMap);
        System.out.println();
        
        Map<String,List<String>> groupedWords = Arrays.asList(string.split(" ")).stream()
                .collect(Collectors.groupingBy(c -> c));
        System.out.println("grouped words: " + groupedWords);
        Map<String,Integer> wordCountMap2 = Arrays.asList(string.split(" ")).stream().collect(
                Collectors.groupingBy(c -> c, Collectors.reducing(0, i -> 1, Integer::sum)));
        System.out.println("word count again: " + wordCountMap2);
   
        double average = integerList.stream().collect(Collectors.averagingInt((Integer i) -> i));
        System.out.println("average value: " + average);
        System.out.println();
        
        // map versus flatMap
        System.out.println("Streaming double list with map():");
        List<List<Integer>> mappedIntList = doubleIntList.stream().map(i -> i).collect(Collectors.toList());
        System.out.println(mappedIntList);
        
        
        System.out.println("Streaming double list with flatMap():");
        List<Integer> flatMappedInts = doubleIntList.stream().flatMap(i -> i.stream()).collect(Collectors.toList());
        System.out.println(flatMappedInts);
        System.out.println();
        
        
        stringList.stream().map(s -> Arrays.asList(s.split(" ")))
                           .forEach(s -> System.out.println(s));
        System.out.println();
        
        stringList.stream().flatMap(s -> Arrays.asList(s.split(" ")).stream())
                           .forEach(s -> System.out.println(s));
        System.out.println();
        
        stringList.stream().map(s -> s.chars())
                           .forEach(s -> System.out.println(s));
        System.out.println();
        
        stringList.stream().flatMapToInt(s -> s.chars())
                           .forEach(s -> System.out.println((char)s));
        System.out.println();
        
        // parallel stream
        integerList.parallelStream().sorted()
                             .map(n -> n + ":" + Thread.currentThread())
                             .forEach(s -> System.out.println(s));
        System.out.println();
    }
}
