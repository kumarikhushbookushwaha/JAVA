package JAVA.DataStructure.Assignmant;

import java.util.LinkedList;

public class SubStringCount {

    static String str = "abracadabra";

    public static void main(String[] args) {
        System.out.println(SubStringCount.subStringCount(str));
    }

    public static int subStringCount(String st) {
        int x = 0;
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < st.length(); i++) {
            for (int j = i; j < st.length(); j++) {
                list.add(st.substring(i, j));
            }
        }

        for (String string : list) {
            for (String string2 : list) {
                if (string.length() > 1 && string2.length() > 1) {
                    if (string.charAt(0) == string2.charAt(0)
                            && string.charAt(string.length() - 1) == string2.charAt(string2.length() - 1))
                        x++;
                    else
                        continue;
                } else
                    continue;
            }
        }

        for (String string : list) {
            System.out.println(string);
        }
        return x;
    }
}
