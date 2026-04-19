package practice.arrays.level3;

import java.util.Scanner;

class DigitFrequencyLevel3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = Math.abs(input.nextLong());
        int[] digits = extractDigits(number);
        int[] frequency = new int[10];

        for (int digit : digits) {
            frequency[digit]++;
        }

        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Frequency of " + i + " = " + frequency[i]);
        }

        input.close();
    }

    static int[] extractDigits(long number) {
        if (number == 0) {
            return new int[] {0};
        }

        long temp = number;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (int) (number % 10);
            number /= 10;
        }
        return digits;
    }
}
