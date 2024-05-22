package com.activemesa.creational.prototype.cloneable;

import lombok.AllArgsConstructor;
import lombok.Data;

// Cloneable is a marker interface
@Data
@AllArgsConstructor
class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    // base class clone() is protected
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber);
    }
}

@Data
@AllArgsConstructor
class Person implements Cloneable {
    public String[] names;
    public Address address;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(
                // clone() creates a shallow copy!
                /*names */ names.clone(),

                // fixes address but not names
                /*address */ // (Address) address.clone()
                address instanceof Cloneable ? (Address) address.clone() : address
        );
    }
}

class CloneableDemo {
    public static void main(String[] args)
            throws CloneNotSupportedException {
        Person john = new Person(new String[]{"John", "Smith"},
                new Address("London Road", 123));

        // shallow copy, not good:
        //Person jane = john;

        // jane is the girl next door
        Person jane = (Person) john.clone();
        jane.names[0] = "Jane"; // clone is (originally) shallow copy
        jane.address.houseNumber = 124; // oops, also changed john

        System.out.println(john);
        System.out.println(jane);
    }
}
