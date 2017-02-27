/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aesencryption.utility;

/**
 *
 * @author Aditya
 */
public class PowerCalculator {

    public static double MyCalc(int number, int power, int mod) {
        int remainingPower;
        double answer;
        int multiple;

        double[] results = new double[power + 1];
        int two = 1;
        int previousTwo = 1;
        results[two] = number % mod;
        /**
         * YOUR RESULTS ARE BEING CALCULATED BY DOUBLING THE POWERS EACH TIME
         * AND THEN TAKING THE MOD THEN A COMBINATION FROM THESE WILL BE MADE TO
         * GIVE THE FINAL ANSWER
         */
        two = 2;

        do {
            results[two] = ((results[previousTwo] % mod) * (results[previousTwo] % mod)) % mod;
            two = two * 2;
            previousTwo = two / 2;
        } while (two <= power);

        if (power == previousTwo) {
//            System.out.println(" ");
//            System.out.println(number + " ^" + power + " mod " + mod + " = " + results[previousTwo]);
            answer = results[previousTwo];
        } else {

            remainingPower = power - previousTwo;
            answer = results[previousTwo];
//            System.out.println(" " + answer);
            previousTwo = previousTwo / 2;

            do {

                if (remainingPower % previousTwo == 0) {
                    multiple = remainingPower / previousTwo;
//                    System.out.println("multi" + multiple);
//                    System.out.println("p2" + results[previousTwo]);
                    for (int count = 1; count <= multiple; count++) {
                        answer = (answer * results[previousTwo]) % mod;
                    }
//                    System.out.println("answer" + answer);
                    break;
                }
                previousTwo = previousTwo / 2;

            } while (previousTwo >= 1);

            answer = answer % mod;
//            System.out.println(" ");
//            System.out.println(number + " ^" + power + " mod " + mod + " = " + answer);
        }
//        System.out.println("answer " +answer);
        return answer;
    }

}
