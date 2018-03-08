package genericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> customList = new CustomListImpl<>(String.class);

        String[] command = bfr.readLine().split(" ");

        while (!command[0].equals("END")){
            switch (command[0]){
                case "Add":
                    customList.add(command[1]);
                    break;
                case "Remove":
                    System.out.println(customList.remove(Integer.parseInt(command[1])));
                    break;
                case "Contains":
                    System.out.println(customList.contains(command[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(command[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList.toString());
                    break;
                case "Sort":
                    Sorter.sort(customList);
            }

            command = bfr.readLine().split(" ");
        }
    }
}
