package generics;

import java.util.*;

public class ForEachDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hallo");
        list.add("Guten Morgen");
        System.out.println("Print String lengths:");
        for (String s : list) {
            System.out.println(s.length());
        }
    }
}
