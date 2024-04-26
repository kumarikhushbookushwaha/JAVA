package JAVA.DataStructure.Sorts;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListSort {
    static List<String> list = new LinkedList<>();

    public static void main(String[] args) {
        list.add("DD");
        list.add("CC");
        list.add("AA");
        list.add("BB");

        ListSort.sort(list);

        for (String string : list) {
            System.out.println(string);
        }
    }

    private static void sort(List<String> list2) {

        Collections.sort(list2);
    }
}
