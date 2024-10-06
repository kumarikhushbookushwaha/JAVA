package GlobusSoft;

import java.util.*;

public class Task1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int[] a = new int[m];
			int[] b = new int[n];
			int[][] c = new int[m][n];
			for (int i = 0; i < m; i++) {
				a[i] = scanner.nextInt();
			}
			for (int i = 0; i < n; i++) {
				b[i] = scanner.nextInt();
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					c[i][j] = scanner.nextInt();
				}

			}
			System.out.println(minCost(a, b, c));
		}
		scanner.close();
	}

	public static int minCost(int[] a, int[] b, int[][] c) {
		int m = a.length;
		int n = b.length;
		int[][] cost = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cost[i][j] = c[i][j] * a[i];
			}
		}
		HungarianAlgorithm ha = new HungarianAlgorithm(cost);
		int[] assignment = ha.execute();
		int totalCost = 0;
		for (int i = 0; i < m; i++) {
			totalCost += cost[i][assignment[i]];
		}
		return totalCost;
	}
}
