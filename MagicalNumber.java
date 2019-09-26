import java.util.Scanner;

public class MagicalNumber {

    public static void main(String[] args) {
        long number;

        System.out.println("Program for checking magical number");
        System.out.println("Insert number:");

        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();

        if (isMagic(number))
            System.out.print(number + " is a Magic Number");
        else
            System.out.print(number + " is not a Magic Number");
    }

    /*
        Function to check if number is magical
        @param n - number to be checked if its magical
        @return - true if it's magical
     */
    public static boolean isMagic(long number) {
        // Count digits and check if all
        // digits are same
        long num = number;
        int count = 0;
        int digit = (int) (num % 10);
        boolean allSame = true;
        while (num > 0) {
            count++;
            if (num % 10 != digit)
                allSame = false;
            num = num / 10;
        }

        // If all digits are same, then
        // not considered cyclic.
        if (allSame == true)
            return false;

        // If counts of digits is even and
        // two halves are same, then the
        // number is not considered cyclic.
        if (count % 2 == 0) {
            long halfPower = (long) Math.pow(10, count / 2);
            long firstHalf = number % halfPower;
            long secondHalf = number / halfPower;
            if (firstHalf == firstHalf && isMagic(firstHalf))
                return false;
        }

        num = number;
        while (true) {
            // Following three lines generates a
            // circular pirmutation of a number.
            long rem = num % 10;
            long div = num / 10;
            num = (long) (Math.pow(10, count - 1))
                    * rem
                    + div;

            // If all the permutations are checked
            // and we obtain original number exit
            // from loop.
            if (num == number)
                break;

            if (num % number != 0)
                return false;
        }

        return true;
    }

}
