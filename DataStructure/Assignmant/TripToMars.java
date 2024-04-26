package JAVA.DataStructure.Assignmant;

import java.util.Scanner;

public class TripToMars {
    private static int gs;
    private static int dest;
    private static char dir;
    private static String steps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grid size:");
        gs = scanner.nextInt();
        System.out.println("Enter destination:");
        dest = scanner.nextInt();
        System.out.println("Enter direction:");
        dir = scanner.next().charAt(0);
        System.out.println("Enter number of steps:");
        steps = scanner.next();

        int result = TripToMars.limit(gs, dest, dir, steps);

        if (result == -1 || result % 10 > gs % 10 || result / 10 > gs / 10) {
            System.out.println("Out of Bound");

        } else {
            System.out.println(result + " " + dir);

        }

        scanner.close();
    }

    public static int limit(int gs2, int dest2, char dir2, String steps2) {
        int X = gs2 / 10;
        int Y = gs2 % 10;

        int x = dest2 / 10;
        int y = dest2 % 10;

        for (int i = 0; i < steps2.length(); i++) {
            {
                if (x >= 0 && y >= 0 && x <= X && y <= Y) {
                    switch (dir2) {
                        case 'N':
                            y--;
                            break;
                        case 'S':
                            y++;
                            break;
                        case 'E':
                            x++;
                            break;
                        case 'W':
                            x--;
                            break;
                    }
                } else
                    return -1;

            }
        }
        return (x * 10) + y;

    }
}
