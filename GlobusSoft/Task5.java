package GlobusSoft;

import java.util.Scanner;

public class Task5 {
    private static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    private static char[][] grid;
    private static boolean[][] visited;
    private static int rows, cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            rows = scanner.nextInt();
            cols = scanner.nextInt();
            int clickX = scanner.nextInt() - 1;
            int clickY = scanner.nextInt() - 1;
            if (rows == 0 && cols == 0 && clickX == -1 && clickY == -1) break;

            grid = new char[rows][cols];
            visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                grid[i] = scanner.next().toCharArray();
            }

            System.out.println(calculatePerimeter(clickX, clickY));
        }
        scanner.close();
    }

    private static int calculatePerimeter(int x, int y) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == '.' || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        int perimeter = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] == '.') {
                perimeter++;
            } else if (!visited[nx][ny]) {
                perimeter += calculatePerimeter(nx, ny);
            }
        }
        return perimeter;
    }
}

