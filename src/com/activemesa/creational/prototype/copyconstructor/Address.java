package com.activemesa.creational.prototype.copyconstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Address {
    public String streetAddress, city, country;

    public Address(Address other) {
        this(other.streetAddress, other.city, other.country);
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    public String name;
    public Address address;

    public Employee(Employee emp) {
        name = emp.name;
        address = new Address(emp.address);
    }

}

class CopyConstructorDemo {
    public static void main(String[] args) {
        Employee john = new Employee("John",
                new Address("123 London Road", "London", "UK"));

        //Employee chris = john;
        Employee chris = new Employee(john);

        chris.name = "Chris";
        chris.address.city = "abc";
        System.out.println(john);
        System.out.println(chris);
    }
}