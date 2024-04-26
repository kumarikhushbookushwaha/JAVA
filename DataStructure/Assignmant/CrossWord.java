package DataStructure.Assignmant;

public class CrossWord {
    static char arr[][] = new char[10][10];

    public static void main(String[] args) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

            }
        }
        CrossWord.fill('*');
        CrossWord.print();
        CrossWord.crossWord("Ramendra", "PANDEY");
        System.out.println("_______________________________________________________");
        CrossWord.print();

    }

    public static void crossWord(String str1, String str2) {
        int x = 0, y = 0;
        /*
         * label: for (char ch1 : str1.toCharArray()) {
         * for (char ch2 : str2.toCharArray()) {
         * if (ch1 == ch2) {
         * break label;
         * } else
         * y++;
         * }
         * x++;
         * }
         */
        label: for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    x = i;
                    y = j;
                    break label;
                }
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            arr[y][i] = str1.charAt(i);
        }

        for (int i = 0; i < str2.length(); i++) {
            arr[i][x] = str2.charAt(i);
        }
    }

    public static void fill(char ch) {
        for (char[] cs : arr) {
            for (int i = 0; i < cs.length; i++) {
                cs[i] = ch;
            }

        }
    }

    public static void print() {
        for (char[] cs : arr) {
            System.out.print("| ");
            for (char c : cs) {
                System.out.print(c + " ");
            }
            System.out.print("|");
            System.out.println();

        }
    }
}
