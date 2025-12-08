import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.StreamSupport.intStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        List<Integer> list = new ArrayList<>();

        list.add(1234);
        list.add(432);
        list.add(1234);
        list.add(432);
        list.add(5678);
        list.add(890);
        list.add(2468);
        list.add(135);
        list.add(9876);

        Long count = list.stream().filter(a -> a> 2000).count();
        System.out.println("Count of numbers greater than 2000: " + count);

        list.stream().filter(b -> b > 2000).map(a -> a * 2).forEach(System.out::println);
        IntStream.rangeClosed(2, (int) Math.sqrt(100)).forEach(System.out::println);

//        list.stream().filter(a -> a%2 ==0).

        System.out.println(isPrime(2));   // true
        System.out.println(isPrime(7));   // true
        System.out.println(isPrime(9));   // false
        System.out.println(isPrime(15));  // false



    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

}