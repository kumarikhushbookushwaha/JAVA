package DataStructure.Assignmant;

public class HappyNumber {
    public static void main(String[] args) {
        double num = 7;
        if (HappyNumber.happyNumber(num) == 1) {
            System.out.println(num + " is a Happy Number");
        } else
            System.out.println(num + " is not a Happy Number");
    }

    private static double happyNumber(double num) {
        num = HappyNumber.calculation(num);

        if (num > 1) {
            num = HappyNumber.happyNumber(num);
        } else {
            return num;
        }

        return num;
    }

    private static double calculation(double num) {
        double result = 0;
        while (num > 0) {
            result = result + Math.pow((num % 10), 2);
            num = (num - (num % 10)) / 10;

        }
        System.out.println("##" + num + "  " + result);

        return result;
    }
}
