package generics;

import java.util.*;

public class GenericsListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hallo");
        list.add("Guten Morgen");
        Iterator<String> iterator = list.iterator();
        System.out.println("Print String lengths:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().length());
        }
    }
}
