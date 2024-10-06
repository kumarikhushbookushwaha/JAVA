
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T-- > 0) {
			String binary = scanner.next();
			System.out.println(getBombIndex(binary));
		}
		scanner.close();
	}

	private static String getBombIndex(String binary) {
		int N = binary.length();
		int index = Integer.parseInt(binary, 2);
		int bombIndex = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (((index >> i) & 1) == 1) {
				bombIndex |= (1 << (N - i - 1));
			}
		}
		return String.format("%" + N + "s", Integer.toBinaryString(bombIndex)).replace(' ', '0');
	}
}
