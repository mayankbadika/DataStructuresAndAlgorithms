package myclass;

public class Test_hash_equal {
    public static void main(String[] args){
        String a = "Andrew";
        String b = "Andrew";

        if(a.equals(b)){   //checking the equality of objects using equals() methods
            System.out.println("a & b are equal variables, and their respective hashvalues are:" + " "+ a.hashCode() + " & " + b.hashCode());

        }

        String c = "Maria";
        String d= "Julie";

        if(!c.equals(d)){    //checking  the equality of objects using equals() method
            System.out.println("\nc & d are Un-equal variables, and their respective hashvalues are:" + " "+ c.hashCode() + " & " + d.hashCode());

        }

        String e = "Andrew";
        String f = new String("Andrew");
        /*
            e.hashCode() and f.hashCode(): The hashCode() method is overridden in the String class to generate
            the same hash code for strings with the same content. Hence, e.hashCode() and f.hashCode() will return
            the same value, even though e and f are different objects.
         */

        if(a.equals(b)){   //checking the equality of objects using equals() methods
            System.out.println("e & f are equal in value but have different references, and their respective hashvalues are:" + " "+ e.hashCode() + " & " + f.hashCode());

        }
    }
}
