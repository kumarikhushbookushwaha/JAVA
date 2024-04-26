package JAVA.DataStructure;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackLinkImp {

    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue1 = new PriorityQueue<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread th1 = new Multithread();
        Thread th2 = new Multithread();
        th1.start();
        th2.start();

        for (int i = 0; i < 11; i++) {
            stack.push(i);
        }

        System.out.println("Stack = " + stack.toString());
        System.out.println("Peek = " + stack.peek());
        System.out.println("pop = " + stack.pop());
        System.out.println("Stack = " + stack.toString());
        System.out.println("Peek = " + stack.peek());
        System.out.println("Size = " + stack.size());

        // for (int i = 0; i < 10; i++) {
        // stack.pop();
        // }

        // String str = stack.toString();

        stack.pop();
        stack.pop();
        // while (!stack.empty()) {
        // stack.pop();
        // }

        if (!stack.empty()) {
            System.out.println(stack.peek());
        }

        System.out.println("Stack = " + stack.toString());
        /*
         * System.out.println(stack.remove(5));
         * System.out.println("Stack = " + stack.toString());
         * int x = stack.capacity();
         * System.out.println(x);
         */

        queue1.offer(2);
        System.out.println(queue1.poll());
        System.out.println(queue1.toString());

        for (int i = 0; i < 10; i++) {
            System.out.print(i + "  ");
            Thread.sleep(i * 1000);
        }

    }
}
