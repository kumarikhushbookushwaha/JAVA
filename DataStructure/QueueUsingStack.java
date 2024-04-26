package JAVA.DataStructure;

import java.util.Stack;

public class QueueUsingStack {
    static Stack<String> stack = new Stack<>();
    static Stack<String> temp = new Stack<>();

    public static void main(String[] args) {
        QueueUsingStack.add("Ramendra");
        QueueUsingStack.add("Aman");
        QueueUsingStack.add("Jagdish");
        QueueUsingStack.add("Ramkishan");
        QueueUsingStack.add("Diksha");

        QueueUsingStack.print();

    }

    public static void add(String str) {
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        stack.push(str);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public static void print() {
        System.out.println("###");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
