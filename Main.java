import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long ccNum;

        do {
            System.out.print("Please enter a credit card number: ");

            if (in.hasNextLong()) {
                ccNum = in.nextLong();
                break;
            } else {
                System.out.println("You did not enter a number");
                in.nextLine();
            }
        } while (true);

        String ccNumStr = String.valueOf(ccNum);

        if (ccNumStr.length() < 13 || ccNumStr.length() > 16) {
            System.out.println(ccNumStr + " is an invalid credit card number.");
            System.exit(-1);
        }

        if (!(ccNumStr.startsWith("4") || ccNumStr.startsWith("5") ||
                ccNumStr.startsWith("37") || ccNumStr.startsWith("6"))) {
            System.out.println(ccNumStr + " is an invalid credit card number.");
            System.exit(-2);
        }


        int sum = 0;

        for (int i = ccNumStr.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(ccNumStr.charAt(i)) * 2;
            if (digit > 9) {
                // Sum the individual digits of numbers greater than 9 (e.g., 18 -> 1 + 8)
                digit = (digit / 10) + (digit % 10);
            }
            sum += digit;
        }

        for (int i = ccNumStr.length() - 1; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(ccNumStr.charAt(i));
            sum += digit;
        }

        if (sum % 10 == 0) {
            System.out.println(ccNumStr + " is a valid credit card number.");
        } else {
            System.out.println(ccNumStr + " is an invalid credit card number.");
        }
    }
}