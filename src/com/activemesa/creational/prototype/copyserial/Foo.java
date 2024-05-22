package com.activemesa.creational.prototype.copyserial;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

// some libraries use reflection (no need for Serializable)

@Data
@AllArgsConstructor
class Foo implements Serializable {
    public int stuff;
    public String whatever;
}

class CopyThroughSerializationDemo {
    public static void main(String[] args) {
        Foo foo = new Foo(42, "life");
        // use apache commons!
        Foo foo2 = SerializationUtils.roundtrip(foo);

        foo2.whatever = "xyz";

        System.out.println(foo);
        System.out.println(foo2);
    }
}
