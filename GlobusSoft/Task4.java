
import java.util.Scanner;

public class Task4 {
	private static int[][] dp;
	private static int[] treats;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		treats = new int[N];
		for (int i = 0; i < N; i++) {
			treats[i] = scanner.nextInt();
		}
		dp = new int[N][N];
		System.out.println(maxRevenue(0, N - 1, 1));
		scanner.close();
	}

	private static int maxRevenue(int left, int right, int day) {
		if (left > right) {
			return 0;
		}
		if (dp[left][right] != 0) {
			return dp[left][right];
		}
		int sellLeft = day * treats[left] + maxRevenue(left + 1, right, day + 1);
		int sellRight = day * treats[right] + maxRevenue(left, right - 1, day + 1);
		dp[left][right] = Math.max(sellLeft, sellRight);
		return dp[left][right];
	}
}
