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
public class PhiNCalc {
    
    public static int Phi (int input){
    int count = 0;
        int coprimeNumber = 0;
        for (int i = 2; i <= input; i++) {
            for (int j = 2; j <= i; j++) {
                if ((i % j) == 0 && (input % j == 0)) { //If any number form 2 to the chosen number is a factor of input
                    count++;
                }
            }
            if (count < 1) { //If no factor add one to the count
                coprimeNumber++;
            }
            count = 0;
        }
        coprimeNumber++; //for consideration of 1
return coprimeNumber;
    }
}
