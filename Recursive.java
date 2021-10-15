/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

/**
 *
 * @author mayank
 */
/*
Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.


countHi("xxhixx") → 1
countHi("xhixhix") → 2
countHi("hi") → 1
*/

public class Recursive {
    public int countHi(String str) {
    if(str=="") return 0;
    int count =0;
    if(str.contains("hi")) count ++;
    int index = str.indexOf("hi");
    if(index!=-1){
      count = count+ countHi(str.substring(index+1,str.length()));
      }
    return count;
}
    public String changeXY(String str) 
    {
        if(str.contains("x")==false) return str;
        String newstr ="";
        int index = str.indexOf("x");
        if(index!=-1){
          newstr = str.replace(str.charAt(index),'y');
        }

        return newstr;
    }
    public String changePi(String str) 
    {
        if(str.contains("pi")==false) return str;
        String newstr ="";
        int index = str.indexOf("pi");
        newstr = str.replace(str.substring(index,index+2),"3.14");

        newstr = changePi(newstr);

        return newstr;
    }
    public String noX(String str) 
    {
        if(str.contains("x")==false ) return str;
        String newstr ="";
        int index = str.indexOf("x");
        newstr = str.replace(str.substring(index,index+1),"");

        newstr= noX(newstr);

        return newstr;  
    }
    
    public boolean array6(int[] nums, int index) 
    {
        boolean flag = false;
        if(nums.length==0) return false;
        if(nums[index]==6) return true;
        if (index<nums.length-1){
          flag = array6(nums,index+1);  
        }
        return flag;
    }
    
    public int array11(int[] nums, int index) 
    {
        int count =0;

        if(nums.length==0) return 0;

        if(nums[index]==11){
          count ++;
        }

        if(index+1<nums.length){
          count = count + array11(nums,index+1);
        }
        return count; 
    }
    /*
    Given an array of ints, compute recursively 
    if the array contains somewhere a value followed 
    in the array by that value times 10. 
    We'll use the convention of considering only the part of 
    the array that begins at the given index. 
    In this way, a recursive call can pass index+1 to move down the array.
    The initial call will pass in index as 0.

    array220([1, 2, 20], 0) → true
    array220([3, 30], 0) → true
    array220([3], 0) → false
    */
    
    public boolean array220(int[] nums, int index) {
        boolean flag = false;

        if(nums.length==0) return false;

        int mul10 = nums[index]*10;
        if(index+1<nums.length){
            if(nums[index+1]==mul10){
              return true;
            }
            flag =array220(nums,index+1);
        }

        return flag;
    }
    
    public String allStar(String str) 
    {
        //String newstr ="";
        if(str =="") return "";
        
        int length=str.length();
        if(str.contains("*")==false){
           str = str.replace(str.substring(0,1),str.substring(0,1)+"*");
           //return str;
        }
        else
        {
            int lastindex = str.lastIndexOf("*")+1;
            if(lastindex<str.length()){
            //newstr = str.replace(str.substring(lastindex+1,lastindex+2),str.substring(lastindex+1,lastindex+2)+"*");
            str = str.replace(str.substring(lastindex,lastindex+1),str.substring(lastindex,lastindex+1)+"*");
            return str;
            }
        }
        
        str=allStar(str);
        return str; 
    }
    
    public String remvow(String str){
        if(str.length()<1)return str;
        char ch = str.toLowerCase().charAt(0);
        
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return ""+remvow(str.substring(1));
        }
        
        return ch+remvow(str.substring(1));
    }
    
    
    
    //driver method
    public static void main(String[] args){
     Recursive s= new Recursive();
     int x =s.countHi("xhixhix");
     //System.out.println(s.allStar("hello"));
     
     System.out.println("removed vowels ="+s.remvow(" QUEUEING"));
    }
    
}
