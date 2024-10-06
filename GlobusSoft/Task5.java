import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    private static final int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
    private static final int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
    private static char[][] grid;
    private static boolean[][] visited;
    private static int rows, cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        scanner.close();

        int index = 0;
        while (index < input.size()) {
            String[] firstLine = input.get(index).split(" ");
            rows = Integer.parseInt(firstLine[0]);
            cols = Integer.parseInt(firstLine[1]);
            int clickX = Integer.parseInt(firstLine[2]) - 1;
            int clickY = Integer.parseInt(firstLine[3]) - 1;
            index++;
            if (rows == 0 && cols == 0 && clickX == -1 && clickY == -1)
                break;

            grid = new char[rows][cols];
            visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                grid[i] = input.get(index).toCharArray();
                index++;
            }

            System.out.println(calculatePerimeter(clickX, clickY));
        }
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
