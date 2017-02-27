/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aesencryption;

import aesencryption.utility.PowerCalculator;
import aesencryption.utility.PhiNCalc;

/**
 *
 * @author Aditya Darshan Acharya
 */
public class AESEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int p = 13;
        int q = 17;
        
        double C;
        double D;
        
        int M = 0;
        int phiN;
        String s = "Ber. Who's there? Fran. Nay, answer me. Stand and unfold yourself. Ber. Long live the King";
//        String s = "Aditya Darshan Acharya";
        String encrypted = "";
        String decrypted = "";

        //choose e such that GCD[phi(p*q), e] = 1; a<e<phi(n)
        int e = 11;
        int d = 35; //modular multiplicative inverse of e

//      int e = 13;
//      int d= 853;
        int n = (p * q);
//      int n=2881;
        PhiNCalc.Phi(n);
        /**
         * ENCRYPTION
         */
        System.out.println("The Encrypted text is");
        System.out.println("");
        for (int i = 0; i < s.length(); i++) {
            C = PowerCalculator.MyCalc(s.charAt(i), e, n);
            System.out.print(Character.toString((char) C));
            encrypted = encrypted + Character.toString((char) C);
        }
        System.out.println("");

        /**
         * DECRYPTION
         */
        System.out.println("");
        System.out.println("The Decrypted text is: ");
        System.out.println("");
        for (int i = 0; i < encrypted.length(); i++) {
            D = PowerCalculator.MyCalc(encrypted.charAt(i), d, n);
            System.out.print(Character.toString((char) D));
            decrypted = decrypted + Character.toString((char) D);
        }
        System.out.println("");

    }

}
