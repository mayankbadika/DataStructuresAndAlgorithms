package myclass;

/**
 * The ImmutablePerson class represents a person with a name, age, and address.
 *
 * This class is designed to be immutable, meaning that once an instance is created,
 * its state cannot be modified. This immutability is achieved through the following practices:
 *
 * 1. **Final Fields**: All fields (name, age, address) are declared as `private` and `final`.
 *    This ensures that they are assigned only once, either in their declaration or in the constructor,
 *    and cannot be changed afterward.
 *
 * 2. **No Setter Methods**: The class provides no setter methods, which means that external code
 *    cannot modify the state of the object after it has been created.
 *
 * 3. **Deep Copying of Mutable Objects**: The `address` field is an instance of the `Address` class,
 *    which, although immutable itself, is still a separate object. To ensure that the `ImmutablePerson`
 *    class remains truly immutable, a deep copy of the `Address` object is made in the constructor.
 *    This prevents external code from modifying the original `Address` object after it has been passed
 *    into the `ImmutablePerson` constructor.
 *
 * 4. **Final Class**: The ImmutablePerson class is declared as `final`, meaning it cannot be subclassed.
 *    This prevents any subclass from introducing mutable fields or methods that could break the immutability
 *    of the class.
 *
 * Why is the ImmutablePerson class final?
 *
 * - **Prevents Subclassing**: By declaring ImmutablePerson as `final`, we ensure that no other class can
 *   extend it and potentially introduce mutable fields or override methods in a way that compromises
 *   the immutability of the class. For example, a subclass might override the `getName()` method to return
 *   a different value or add a setter method that alters the state of the object.
 *
 * - **Ensures Consistency**: Declaring the class as `final` guarantees that the immutability properties
 *   of the class are preserved. This makes the class more predictable and easier to work with, as you
 *   can be confident that its state will never change after construction.
 */

final class ImmutablePerson {
    private final String name;
    private final int age;
    private final Address address;

    public ImmutablePerson(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        // Create a deep copy of the address to ensure immutability
        this.address = new Address(address.getStreet(), address.getCity(), address.getZipCode());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        // Return a copy of the address to prevent modification of the original object
        return new Address(address.getStreet(), address.getCity(), address.getZipCode());
    }

    // Address class should also be immutable
    /**
     * The Address class is an example of an immutable class in Java.
     *
     * Immutability is a design principle where an object's state cannot be modified after it is created.
     * This means that once an instance of an immutable class is constructed, all of its fields are effectively
     * read-only, and no external code can change its state. Immutability offers several advantages:
     *
     * 1. **Thread-Safety**: Immutable objects are inherently thread-safe because their state cannot be changed
     *    after creation. This eliminates the need for synchronization when sharing immutable objects between threads.
     *
     * 2. **Simpler Code**: Since immutable objects do not change state, the code that uses them tends to be simpler
     *    and less error-prone. You don't have to worry about unexpected modifications, leading to fewer bugs.
     *
     * 3. **Safe Hashing**: Immutable objects are safe to use as keys in hash-based collections like HashMap or HashSet.
     *    Their hash codes are guaranteed to remain constant, which is a crucial property for objects used in such collections.
     *
     * The Address class is made immutable by:
     *
     * - Declaring all fields as `private` and `final`. This ensures that they are set only once, either in their
     *   declaration or in the constructor, and cannot be changed afterward.
     * - Providing only getter methods, without any setter methods. This prevents any external modification of the fields.
     * - Performing defensive copying for any mutable fields passed into the constructor, though in this example,
     *   all fields are of immutable types (String).
     *
     * Additionally, the Address class is declared as `final`.
     *
     * Why is the Address class final?
     *
     * - **Prevents Subclassing**: By declaring the Address class as `final`, we prevent any other class from subclassing it.
     *   This is important because a subclass could potentially introduce mutable fields or override methods in a way that
     *   breaks the immutability contract. For example, a subclass might override a method to return a modified value
     *   or add a setter method that alters the state of the object.
     *
     * - **Ensures Consistency**: Declaring the class as `final` guarantees that the immutability properties of the class
     *   are preserved throughout the application's lifecycle. No subclass can undermine the design, ensuring that all
     *   instances of Address are truly immutable.
     */
    public static final class Address {
        private final String street;
        private final String city;
        private final String zipCode;

        public Address(String street, String city, String zipCode) {
            this.street = street;
            this.city = city;
            this.zipCode = zipCode;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getZipCode() {
            return zipCode;
        }
    }
}

public class ImmutableClass {
    public static void main(String[] args) {
        ImmutablePerson.Address address = new ImmutablePerson.Address("123 Main St", "Springfield", "12345");
        ImmutablePerson person = new ImmutablePerson("John Doe", 30, address);

        // Attempting to modify the address will not affect the original object
        ImmutablePerson.Address newAddress = person.getAddress();
        newAddress = new ImmutablePerson.Address("456 Elm St", "Shelbyville", "67890");

        // The original person object remains unchanged
        System.out.println(person.getName());  // Output: John Doe
        System.out.println(person.getAge());   // Output: 30
        System.out.println(person.getAddress().getStreet());  // Output: 123 Main St

    }
}

