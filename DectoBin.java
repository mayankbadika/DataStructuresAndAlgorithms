/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

/**
 *
 * @author mbadika
 */
public class DectoBin {

    /**
     * Convert a decimal number to binary.
     *
     * @param n the decimal number to convert
     */
    public void dectobin(int n) {
        double dec = 0;
        int i = 0;

        // Convert decimal to binary
        while (n > 0) {
            dec = dec + (n % 10) * Math.pow(2, i);
            n = n / 10;
            i++;
        }

        // Print the binary number
        System.out.println((int)dec);
    }

    /**
     * Converts a decimal number to binary.
     *
     * @param decimal the decimal number to be converted
     * @return the binary representation of the decimal number
     */
    public static void main(String[] args) {
        DectoBin obj = new DectoBin();
        obj.dectobin(11110001);
    }
}
