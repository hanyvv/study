package intro;

import java.util.Scanner;

public class ConsoleBasedFizzBuzz implements FizzBuzz{

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();
        FizzBuzz fizzBuzz = new ConsoleBasedFizzBuzz();

        fizzBuzz.print(1, end);
    }
    @Override
    public void print(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 15 == 0) {
                System.out.println(FIZZ + BUZZ);
            } else if (i % 3 == 0) {
                System.out.println(FIZZ);
            } else if (i % 5 == 0) {
                System.out.println(BUZZ);
            }else System.out.println(i);
        }

    }
}

