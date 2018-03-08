package genericBox;

public interface CustomList<T extends Comparable<T>> extends Iterable<T>{

    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int firstIndex, int secondIndex);

    int countGreaterThan(T element);

    T getMax();

    T getMin();

    T getElement(int index);

    int getSize();
}
