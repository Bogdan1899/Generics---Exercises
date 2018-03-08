package genericBox;

public class Sorter {

    public static <T extends Comparable<T>> CustomList<T> sort(CustomList<T> customList){
        for (int i = 0; i < customList.getSize() - 1; i++) {
            int index = i;

            for (int j = i + 1; j < customList.getSize(); j++) {
                T firstElement = customList.getElement(index);
                T secondElement = customList.getElement(j);

                if (firstElement.compareTo(secondElement) > 0){
                    index = j;
                }

                customList.swap(i, index);
            }
        }

        return customList;
    }
}
