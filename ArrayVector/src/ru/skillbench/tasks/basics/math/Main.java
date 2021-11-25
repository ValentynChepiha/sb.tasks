package ru.skillbench.tasks.basics.math;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello? I'm a Vector");

//        ArrayVector myVector = new ArrayVectorImpl();
//
//        myVector.set(5, 0.25);
//        System.out.println(myVector.toString());
//        System.out.println(myVector.get(2));

        ArrayVector myVector = new ArrayVectorImpl();
        myVector.set(1.2, 1.25, 3.25, 0.25, 8.15);

        ArrayVector myVector2 = new ArrayVectorImpl();
        myVector2.set(3, 2.1, 0.45, 2.65, 1.07);

        System.out.println();
//
//        System.out.println(myVector.toString());
//        System.out.println(myVector2.toString());
//
//        System.out.println(myVector.scalarMult(myVector2));
//
//        myVector.mult(5);
//        System.out.println(myVector.toString());
//
//        myVector.sortAscending();
//
//        System.out.println(myVector.toString());
//
//        System.out.println(Math.pow(3, 2));

    }
}
