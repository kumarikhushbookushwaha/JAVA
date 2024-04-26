package JAVA;

public class StringRiversal {

    public static void main(String[] args) {
        String str = "Hippopotomonstrosesquippedaliophobia";
        System.out.println("Original String = " + str);
        System.out.println("Riverse String = " + StringRiversal.stringRiversal(str));
    }

    public static String stringRiversal(String str) {
        char[] arr1 = str.toCharArray();
        char[] arr2 = new char[str.length()];

        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[arr1.length - 1 - i];
        }

        String str1 = String.valueOf(arr2); // Autoboxing
        return str1.toUpperCase();
    }
}
