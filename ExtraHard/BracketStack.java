package JAVA.ExtraHard;

import java.util.Scanner;
import java.util.Stack;

public class BracketStack {
    public static void main(String[] args) {
        Character[] arr = BracketStack.input();
        boolean flag = BracketStack.test(arr);

        if (flag) {
            System.out.println("Valid Statement");
        } else {
            System.out.println("Not a Valid Statement");
        }

    }

    public static Character[] input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Equation");
        String str = scanner.next();
        Character[] charArr = new Character[str.length()];

        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = str.charAt(i);
        }
        scanner.close();
        return charArr;
    }

    public static boolean test(Character[] arr) {
        Stack<Character> stack = new Stack<>();
        boolean flag2 = false;
        for (Character ch : arr) {
            if (!stack.empty()) {
                flag2 = (stack.peek() == '(' && (ch == '}' || ch == ']'))
                        || (stack.peek() == '{' && (ch == ')' || ch == ']'))
                        || (stack.peek() == '[' && (ch == '}' || ch == ')'));
            } else if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // else if (flag2)
            // return false;
            else if (stack.peek() == '(' && ch == ')')
                stack.pop();
            else if (stack.peek() == '{' && ch == '}')
                stack.pop();
            else if (stack.peek() == '[' && ch == ']')
                stack.pop();

        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
