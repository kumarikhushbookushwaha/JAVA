package JAVA.ExtraHard;

import java.util.Scanner;
import java.util.Stack;

public class Praikshak {
    public static void main(String[] args) {
        Character[] charArr = Praikshak.input();

        Integer result = Praikshak.checkPostfix(charArr);

        if (result == -1) {
            System.out.println("Invalid input");
        } else {
            System.out.println("Result of the postflix = " + result);
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

    public static Integer checkPostfix(Character[] charArr) {

        Stack<Integer> stack = new Stack<>();
        Integer result = -1;
        for (Character ch : charArr) {

            if ((ch == '+' || ch == '/' || ch == '*' || ch == '-') && !stack.empty()) {

                Integer num1 = stack.pop();
                Integer num2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                    default:
                        break;
                }
            }

            else {
                try {
                    stack.push(Integer.valueOf(ch));

                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }
        }

        if (stack.size() == 1) {
            result = stack.pop();
        }
        return result;
    }
}
