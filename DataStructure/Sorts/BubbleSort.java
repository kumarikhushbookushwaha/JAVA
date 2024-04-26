package JAVA.DataStructure.Sorts;

public class BubbleSort {

    static int arr[] = { 45, 68, 159, 35, 4, 30, 15, 856, 412, 194, 32, 4, 67 };

    public static void main(String[] args) {
        for (int i : BubbleSort.bubbleSort(arr)) {
            System.out.print(i + "  ");
        }
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
}