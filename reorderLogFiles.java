/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

/**
 *
 * @author mbadika
 * 
 * You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 

Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class reorderLogFiles {
    public static void main(String[] args){
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        //Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]

        // Pushing all dig type logs at the end

        
        for(int j=1;j<=2;j++){
            for(int i=0;i<logs.length-1;i++){
                String[] split = logs[i].split(" ");
                if(split[0].contains("dig")) {
                    String temp = logs[i];
                    logs[i]=logs[i+1];
                    logs[i+1]= temp;
                }   
            }
        }
        
        //After pushing dig logs down
        System.out.println("After pushing dig logs down");
        for(int i=0;i<logs.length;i++){
            System.out.println(logs[i]);
        }
    
    
    }
    
}
