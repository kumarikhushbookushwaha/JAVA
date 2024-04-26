package JAVA.DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    static Queue<String> q1 = new LinkedList<>();
    static Queue<String> q2 = new LinkedList<>();

    public static void main(String[] args) {

        StackUsingQueue.add("Ramendra");
        StackUsingQueue.add("Pandey");
        StackUsingQueue.add("Aman");
        StackUsingQueue.add("Jagdish");
        StackUsingQueue.add("Ramkishan");
        StackUsingQueue.print();
    }

    public static void add(String str) {
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.poll();
        }
        q1.add(str);
        while (!q2.isEmpty()) {
            q1.add(q2.peek());
            q2.poll();
        }
    }

    public static void print() {
        System.out.println("###");

        for (String st : q1) {
            System.out.print(st + "  ");
        }
    }

}
