package com.example.javaalgo.LLD;

public class MultipleInheritsMultipleImplements {

    public static void main(String[] args) {

    }

}

class TempA implements IA, IB {

    @Override
    public void doSomethingA() {

    }

    @Override
    public void doSomethingB() {

    }
}

class TempB extends CA {

    TempB() {
        super("Prudhvi");
    }
}

class TempC extends CB implements IA, IB {

    TempC() {
        super(10);
    }

    @Override
    public void doSomethingA() {

    }

    @Override
    public void doSomethingB() {

    }
}

interface IA {
    void doSomethingA();
}

interface IB {
    void doSomethingB();
}

class CA {
    String name;

    CA(String name) {
        this.name = name;
    }

    String getName() {
        return name + " hello";
    }
}

class CB {
    int age;

    CB(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }
}
