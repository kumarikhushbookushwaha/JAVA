package JAVA.DataStructure.Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortSearch {
    static int ind = -1;

    public static void main(String[] args) {
        int[] arr = SortSearch.generateArray(10);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Original Array = " + Arrays.toString(arr));
        arr = SortSearch.bubbleSort(arr);
        System.out.println("Sorted Array = " + Arrays.toString(arr));
        System.out.println("---------------Enter number to be searched---------------");
        int x = scanner.nextInt();
        int index = SortSearch.binearySearch(arr, 0, 9, x);
        System.out.println("Index of " + x + " in array = " + index);
        scanner.close();
    }

    private static int[] generateArray(int i) {

        Random random = new Random();
        int arr[] = new int[i];
        for (int j = 0; j < i; j++) {
            arr[j] = random.nextInt(1000);
        }
        return arr;
    }

    public static int[] bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = 0;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                } else {
                    continue;
                }
            }
        }
        return arr;
    }

    public static int binearySearch(int[] arr, int left, int right, int num) {

        int mid = (left + right) / 2;

        if (left < right) {

            if (num < arr[mid]) {
                SortSearch.binearySearch(arr, left, mid - 1, num);

            } else if (num > arr[mid]) {
                SortSearch.binearySearch(arr, mid, right, num);

            } else if (num == arr[mid]) {
                ind = mid;
            }
            return ind;
        } else
            return ind;

    }
}
