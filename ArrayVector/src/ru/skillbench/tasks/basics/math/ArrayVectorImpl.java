package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector {
    private double[] vector;

    public ArrayVectorImpl() {
        vector = new double [0];
    }

    public ArrayVectorImpl(double... elements) {
        vector = copyArray(elements);
    }

    private double[] copyArray(double[] elements){
        int length = elements.length;
        double[] newVector = new double[length];
        System.arraycopy(elements, 0, newVector, 0, elements.length);
        return newVector;
    }

    @Override
    public void set(double... elements) {
        vector = copyArray(elements);
    }

    @Override
    public double[] get() {
        return vector;
    }

    @Override
    public ArrayVector clone() {
        return new ArrayVectorImpl(vector);
    }

    @Override
    public int getSize() {
        return vector.length;
    }

    @Override
    public void set(int index, double value)  {
        if(index >= 0){
            if(getSize()<=index){
                double[] newVector = new double[index+1];
                System.arraycopy(vector, 0, newVector, 0, getSize());
                vector = newVector;
            }
            vector[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if(index <0 || index > getSize())
            throw new ArrayIndexOutOfBoundsException();
        return vector[index];
    }

    @Override
    public double getMax() {
        double max = Double.MAX_VALUE * -1;
        for (double element : vector) {
            max = Math.max(element, max);
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = Double.MAX_VALUE;
        for (double element : vector) {
            min = Math.min(element, min);
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(vector);
    }

    @Override
    public void mult(double factor) {
        for (int i=0; i<getSize(); i++) {
            vector[i] = vector[i] * factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        for(int i=0; i<getSize(); i++){
            set(i, get(i) + (i<anotherVector.getSize() ? anotherVector.get(i) : 0.0));
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        int sizeMinVector = Math.min(getSize(), anotherVector.getSize());
        double result = 0.0;
        for (int i=0; i<sizeMinVector; i++ ){
            result = result + get(i) * anotherVector.get(i);
        }
        return result;
    }

    @Override
    public double getNorm() {
        double norm = 0.0;
        for(int i=0; i<getSize(); i++){
            norm = norm + Math.pow(get(i),2);
        }
        return Math.sqrt(norm);
    }
}