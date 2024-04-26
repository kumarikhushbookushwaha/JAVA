package JAVA.DataStructure.Assignmant;

public class Padosan {
    static int[] arr = { 11313313, 31515333, 51717353, 13333515, 1733919, 37575939, 54747656 };

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (Padosan.padosan(arr[i], arr[j])) {
                    System.out.println("( " + (i + 1) + " , " + (j + 1) + " )");
                } else
                    continue;
            }
        }
    }

    private static boolean padosan(int num1, int num2) {
        boolean flag = false;
        int s11 = num1 % 100;
        int s12 = ((num1 % 10000) - s11) / 100;
        int s13 = ((num1 % 1000000) - s11 - s12 * 100) / 10000;
        int s14 = (num1 - s11 - s12 * 100 - s13 * 10000) / 1000000;

        int s21 = num2 % 100;
        int s22 = ((num2 % 10000) - s11) / 100;
        int s23 = ((num2 % 1000000) - s11 - s12 * 100) / 10000;
        int s24 = (num2 - s11 - s12 * 100 - s13 * 10000) / 1000000;

        int arr1[] = { s11, s12, s13, s14 };
        int arr2[] = { s21, s22, s23, s24 };

        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j) {
                    flag = true;
                } else {
                    continue;
                }
            }
        }

        return flag;
    }

}
