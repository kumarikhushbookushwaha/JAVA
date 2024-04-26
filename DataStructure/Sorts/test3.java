package JAVA.DataStructure.Sorts;

import JAVA.DataStructure.Test2;

import java.util.LinkedList;
import java.util.Stack;

public class test3 {
    static  final int x = 10;

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("Aashu");
        stack.push("Ram");

        System.out.println(stack.toString());

        while (true) {
            if (!stack.isEmpty())
                System.out.println(stack.pop());
            else break;
        }
        System.out.println(stack.toString());


        switch (x)
        {
            case 1:
                System.out.println("ONE");

                case 2:
            System.out.println("TWO");

            case 3:
            System.out.println("Three");

            case 4:
            System.out.println("Four");
            break;
            default:
                System.out.println("HIII");
        }
    }


}
