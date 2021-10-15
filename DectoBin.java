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
    
    public void dectobin(int n){
        double dec =0; int i=0;
        while(n>0){
            dec = dec+(n%10)*Math.pow(2, i);
            n=n/10;i++;
        }
        System.out.println((int)dec);
    }
    
    public static void main(String[] args){
        DectoBin obj = new DectoBin();
        obj.dectobin(11110001);
    }
}
