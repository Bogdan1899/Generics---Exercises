package genericBox;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final int DEFAULT_INDEX = 0;

    private Class<T> classType;

    private T[] innerArray;

    private int currentIndex;

    @SuppressWarnings("unchecked")
    public CustomListImpl(Class<T> classType) {
        this.classType = classType;
        innerArray = (T[]) Array.newInstance(classType, DEFAULT_CAPACITY);
        this.currentIndex = DEFAULT_INDEX;
    }

    @Override
    public void add(T element) {
        if (currentIndex >= this.innerArray.length){
            resize();
        }

        this.innerArray[currentIndex++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        T elementToRemove = this.innerArray[index];
        T[] newArray = (T[]) Array.newInstance(this.classType, this.innerArray.length);
        int j = 0;
        for (int i = 0; i < this.currentIndex; i++) {
            if (i == index){
                i++;
            }

            newArray[j] = this.innerArray[i];
            j++;
        }

        this.innerArray = newArray;
        this.currentIndex--;
        return elementToRemove;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < currentIndex; i++) {
            if (this.innerArray[i].equals(element)){
                return true;
            }
        }

        return false;
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.innerArray[firstIndex];
        T secondElement = this.innerArray[secondIndex];

        this.innerArray[firstIndex] = secondElement;
        this.innerArray[secondIndex] = firstElement;
    }

    @Override
    public int countGreaterThan(T element) {
        int counter = 0;

        for (int i = 0; i < this.currentIndex; i++) {
            if (this.innerArray[i].compareTo(element) > 0){
                counter++;
            }
        }

        return counter;
    }

    @Override
    public T getMax() {
        T max = this.innerArray[0];

        for (int i = 1; i < currentIndex; i++) {
            if (this.innerArray[i].compareTo(max) > 0){
                max = this.innerArray[i];
            }
        }

        return max;
    }

    @Override
    public T getMin() {
        T min = this.innerArray[0];

        for (int i = 1; i < currentIndex; i++) {
            if (this.innerArray[i].compareTo(min) < 0){
                min = this.innerArray[i];
            }
        }

        return min;
    }

    @Override
    public T getElement(int index) {
        if (index >= 0 && index < currentIndex){
            return this.innerArray[index];
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getSize() {
        return this.currentIndex;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < this.currentIndex; i++) {
            output.append(this.innerArray[i]);
            if (i != this.currentIndex - 1){
                output.append(System.lineSeparator());
            }
        }

        return output.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private void resize(){
        this.innerArray = Arrays.copyOf(this.innerArray, DEFAULT_CAPACITY * 2);
    }

    private class MyIterator implements Iterator<T>{

        private int index;

        private MyIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < currentIndex;
        }

        @Override
        public T next() {
            if (hasNext()){
                return innerArray[index++];
            }

            throw new IndexOutOfBoundsException();
        }
    }
}
