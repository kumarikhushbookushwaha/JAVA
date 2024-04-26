package JAVA.DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

    static ArrayList<String> arraylist = new ArrayList<>();
    static List<String> list = new LinkedList<>();
    static String[] arr = new String[5];
    static HashMap<Integer, String> hashMap = new HashMap<>();
    static HashSet<String> hashSet = new HashSet<>();

    // static final int x = 10; Constant in java

    public static void main(String[] args) {
        Test2.fillArray();
        Collections.sort(arraylist);
        Collections.sort(list);

        arraylist.size();

        Object arr4 = arraylist.clone();
        /*
         * int a = arr.length;
         * String stre;
         * stre.length();
         * String b []= Test2.arr;
         * 
         */

        Arrays.sort(arr);
        List<String> l1 = new LinkedList<String>();
        l1 = Arrays.asList(arr);
        Test2.print(arraylist.toString(), "ArrayList");
        Test2.print(list.toString(), "List");
        Test2.print(hashMap.toString(), "HashMap");
        Test2.print(hashSet.toString(), "HashSet");
        Test2.print(Arrays.toString(arr), "Array");

    }

    public static void fillArray() {
        arr[0] = "Beta";
        arr[1] = "Alpha";
        arr[2] = "Gama";
        arr[3] = "Dalta";
        arr[4] = "Sigma";
        int x = 0;



        for (String string : arr) {
            arraylist.add(string);
            list.add(string);
            hashMap.put(x, string);
            hashSet.add(string);
            x++;
        }
    }

    public static void print(String str1, String str2) {
        System.out.println("Printing values from " + str2);
        System.out.println(str1);
        System.out.println("----------------------------------------------------");
    }

}
