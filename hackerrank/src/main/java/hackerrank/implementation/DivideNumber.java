package hackerrank.implementation;

import java.util.Scanner;

/**
 * Created by deyv on 8/25/15.
 */
public class DivideNumber {

    public static int getDivisorCounts(long input) {
        long temp = input;
        int count = 0;

        while(temp != 0) {
            long digit = temp % 10;
            if(digit != 0 && input % digit == 0 ){
                count++;
            }
            temp = temp / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getDivisorCounts(1012));
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//
//        for (int i = 0; i < T; i++) {
//            int n = scanner.nextInt();
//            System.out.println(getDivisorCounts(n));
//        }
//
//        scanner.close();


    }
}
