package JAVA.DataStructure.Assignmant;

public class Shabdkosh {
    static String arr[] = { "whisper", "format", "perform", "sonnet", "person", "shopper", "workshop", "network" };
    static String arr3[] = { "start", "finish" };
    static int n = 0;

    public static void main(String[] args) {
        String arr1[] = Shabdkosh.shabdkosh(arr3);
        if (n == 0) {
            System.out.println("Imposible");
        } else {

            for (String string : arr1) {
                System.out.println(" " + string + " ");
            }
        }
    }

    private static String[] shabdkosh(String[] arr2) {
        String[] array = new String[arr.length];

        for (String string : arr2) {
            for (String string2 : arr2) {

                String temp1 = string.substring(string.length() - 3);
                String temp2 = string2.substring(0, 3);

                // System.out.println("##" + string + " = " + temp1 + "##" + string2 + " = " +
                // temp2 + i + " " + n);
                if (string.equals(string2))
                    continue;
                else if (temp1.equals(temp2)) {
                    array[n] = string;
                    array[n + 1] = string2;
                    n += 2;
                    break;
                } else if (temp1.equals(temp2)) {
                    array[n] = string2;
                    array[n + 1] = string;
                    n += 1;
                    break;
                } else
                    continue;
            }

        }
        return array;
    }
}
