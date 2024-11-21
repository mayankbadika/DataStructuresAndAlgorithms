package myclass.Stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main (String[] args) {
        String path = "/Users/mayankbadika/Documents/TestFiles/MOCK_DATA.csv";

        try {
            // Read files using stream
            Stream<String> stream = Files.lines(Paths.get(path)).parallel();

            List<Employee> employees = stream
                    .skip(1) // Skip the header line if there is one
                    .map(line -> {
                        String[] fields = line.split(",");
                        return new Employee(
                                Integer.parseInt(fields[0]),      // id
                                fields[1],                        // firstName
                                fields[2],                        // lastName
                                fields[3],                        // email
                                fields[4],                        // gender
                                fields[5],                        // ipAddress
                                Integer.parseInt(fields[6])       // salary
                        );
                    })
                    .filter(employee -> employee.getSalary() > 10000)
                    .collect(Collectors.toList());


            System.out.println(employees);

        } catch (Exception e) {
            System.err.println("exception message = "+e);
        }
    }
}

class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;
    private int salary;

    // Constructors

    public Employee(int id, String firstName, String lastName, String email, String gender, String ipAddress, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // toString method for easy representation
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", salary=" + salary +
                '}';
    }
}

