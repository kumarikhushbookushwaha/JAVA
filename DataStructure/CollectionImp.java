package JAVA.DataStructure;

import java.util.*;
import java.util.LinkedList;

public class CollectionImp {
    static List<String> list = new LinkedList<>();
    static LinkedList<String> linkedlist = new LinkedList<>();
    static HashMap<Integer, String> hashmap = new HashMap<>();
    static HashSet<String> hashset = new HashSet<>();
    static ArrayList<String> arraylist = new ArrayList<>();
    static String[] array = new String[5];

    public static void main(String[] args) {
        CollectionImp.enteringValue();
        Collections.sort(list);
        Collections.sort(linkedlist);
        Collections.sort(arraylist);
        Arrays.sort(array);
        Collections.reverse(list);
        CollectionImp.print(arraylist.toString(), "ArrayList");
        CollectionImp.print(list.toString(), "List");
        CollectionImp.print(Arrays.toString(array), "Array");
        CollectionImp.print(hashmap.toString(), "HaashMap");
        CollectionImp.print(hashset.toString(), "HashSet");

    }

    public static void enteringValue() {
        list.add("delta");
        list.add("alpha");
        list.add("sigma");
        list.add("beta");
        list.add("gama");
        int x = 0;
        for (String str : list) {
            linkedlist.add(str);
            hashmap.put(x, str);
            hashset.add(str);
            arraylist.add(str);
            array[x] = str;
            x++;
        }

    }

    public static void print(String str2, String string) {
        System.out.println("Printing data from " + string);
        System.out.print(str2);
        System.out.println();
        System.out.println("-------------------------------------------------");
    }
}
