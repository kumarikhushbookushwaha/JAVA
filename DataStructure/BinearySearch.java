package DataStructure;

public class BinearySearch {
    static int ind = -1;

        int arr[] = { 1, 2, 3, 6, 8, 14, 24, 39, 54, 87, 102, 265, 475, 985 };
        int x = 50;
        int index = BinearySearch.binearySearch(arr, 0, 14, x);
        if (index == -1) {
            System.out.println("Invalid Search");
        } else {
            System.out.println("Index of " + x + " in Array = " + index);

        }
    }

    public static int binearySearch(int[] arr, int left, int right, int num) {

        int mid = (left + right) / 2;

        if (left < right) {

            if (num < arr[mid]) {
                BinearySearch.binearySearch(arr, left, mid - 1, num);

            } else if (num > arr[mid]) {
                BinearySearch.binearySearch(arr, mid, right, num);

            } else if (num == arr[mid]) {
                ind = mid;
            }
            return ind;
        } else
            return ind;

    }
}
