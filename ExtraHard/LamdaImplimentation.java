package JAVA.ExtraHard;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LamdaImplimentation {
    public static void main1(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int num: arr)
            arrList.add(num);
        arrList.forEach((n) -> {System.out.println(n);} );

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int num: arr)
            arrList.add(num);
        Consumer<Integer> lamda= (n) -> {System.out.println(n);};
        arrList.forEach(lamda);

    }
}
