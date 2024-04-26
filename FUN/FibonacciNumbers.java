package JAVA.FUN;

import java.util.Arrays;

public class FibonacciNumbers {
    static int num = 2;
    static int arr[] = new int[20];

    public static void main(String[] args) {
        arr[0] = 0;
        arr[1] = 1;
        arr = FibonacciNumbers.fibonacci(20);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] fibonacci(int numb) {

        while (num < numb) {
            arr[num] = arr[num - 1] + arr[num - 2];
            num++;
        }
        return arr;
    }
}
