package JAVA.FUN;

public class ProgressBar {
    public static void main(String[] args) {
        char[] arr = new char[11];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = '_';
        }
        for (int i = 0; i <= 100; i++) {
            arr[i / 10] = '*';
            System.out.print("[ ");
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.print(" ]  " + i + "%");
            System.out.println();
            try {
                Runtime.getRuntime().exec("cls");
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
