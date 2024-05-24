package hackerearth;

import java.math.BigInteger;
import java.util.Scanner;

public class LamdaCreation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int i = sc.nextInt();

        for (int j = 0; j < i; j++) {
            final int x = sc.nextInt();
            final int y = sc.nextInt();

            switch (x) {
                case 1 -> {
                    if (doStuff(isOdd(), y)) {
                        System.out.println("ODD");
                    } else {
                        System.out.println("EVEN");
                    }
                }
                case 2 -> {
                    if (doStuff(isPrime(), y)) {
                        System.out.println("PRIME");
                    } else {
                        System.out.println("COMPOSITE");
                    }
                }
                case 3 -> {
                    if (doStuff(isPalindrome(), y)) {
                        System.out.println("PALINDROME");
                    } else {
                        System.out.println("NOT PALINDROME");
                    }
                }
            }
        }
    }

    static boolean doStuff(PerformOperation p, int num) {
        return p.doCalculation(num);
    }

    private static PerformOperation isOdd() {
        return a -> a % 2 == 1;

    }

    private static PerformOperation isPrime() {
        return a -> new BigInteger(String.valueOf(a)).isProbablePrime(1);
    }

    private static PerformOperation isPalindrome() {
        return a -> new StringBuilder(String.valueOf(a)).reverse().toString().equals(String.valueOf(a));
    }

}

@FunctionalInterface
interface PerformOperation {
    boolean doCalculation(int a);
}
