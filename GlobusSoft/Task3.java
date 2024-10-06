
import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(convertToBaseNegativeTwo(num));
		scanner.close();
	}

	private static String convertToBaseNegativeTwo(int num) {
		if (num == 0) {
			return "0";
		}

		StringBuilder result = new StringBuilder();
		while (num != 0) {
			int remainder = num % -2;
			num /= -2;

			if (remainder < 0) {
				remainder += 2;
				num += 1;
			}

			result.append(remainder);
		}

		return result.reverse().toString();
	}
}
