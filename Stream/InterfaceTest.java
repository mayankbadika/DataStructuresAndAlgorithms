package myclass.Stream;

interface A {
    String name = "Mayank"; // Implicitly public, static, and final
}

class Parent {
     static String lastname = "lastname from parent class";
}

public class InterfaceTest extends Parent implements A{
    public static void main (String[] args) {
        InterfaceTest obj = new InterfaceTest();

        System.out.println(A.name);
        System.out.println(obj.name);

        //obj.name ="Badika"; // This will generate an error
        /*
            The error occurs because the variable in an interface is implicitly final.
            In Java, all variables declared in an interface are implicitly public, static, and final.
            This means you cannot change the value of a static variable declared in an interface.
         */

        System.out.println(Parent.lastname);
        System.out.println(InterfaceTest.lastname);

        InterfaceTest.lastname = "Interface provided lastname";

        System.out.println(Parent.lastname);
        System.out.println(InterfaceTest.lastname);

        /*
            In Java, static variables belong to the class rather than to any specific instance.
            This means that there is only one copy of a static variable, regardless of how many
            instances of the class are created. When a class inherits from another class, it
            inherits the static variables as well, but there is still only one copy of the static
            variable shared among all instances of both the parent and child classes.

            However, the child class can change the value of the inherited static variable. Since
            static variables are shared, any change made to a static variable through one class or
            instance will be reflected in all classes and instances that have access to that variable.
        */

    }
}
