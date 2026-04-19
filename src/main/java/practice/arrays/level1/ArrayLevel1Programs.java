package practice.arrays.level1;

import java.util.Scanner;

class StudentVotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = input.nextInt();
        }

        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        input.close();
    }
}

class NumberArrayAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        for (int number : numbers) {
            if (number > 0) {
                String parity = (number % 2 == 0) ? "even" : "odd";
                System.out.println(number + " is positive and " + parity);
            } else if (number < 0) {
                System.out.println(number + " is negative");
            } else {
                System.out.println(number + " is zero");
            }
        }

        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("First and last elements are equal.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element is greater than last element.");
        } else {
            System.out.println("First element is less than last element.");
        }

        input.close();
    }
}

class MultiplicationTableArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] multiplicationTable = new int[10];

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        for (int i = 1; i <= multiplicationTable.length; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        for (int i = 1; i <= multiplicationTable.length; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationTable[i - 1]);
        }

        input.close();
    }
}

class PositiveNumbersSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        int index = 0;

        while (true) {
            if (index == numbers.length) {
                break;
            }

            System.out.print("Enter a positive number, or 0/negative to stop: ");
            double number = input.nextDouble();

            if (number <= 0) {
                break;
            }

            numbers[index] = number;
            index++;
        }

        double total = 0.0;
        System.out.println("Entered positive numbers:");
        for (int i = 0; i < index; i++) {
            total += numbers[i];
            System.out.println(numbers[i]);
        }

        System.out.println("Total value is " + total);
        input.close();
    }
}

class MultiplicationTableSixToNine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] multiplicationResult = new int[4];

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        input.close();
    }
}

class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
            sum += heights[i];
        }

        double mean = sum / heights.length;
        System.out.println("The mean height of the football team is " + mean);
        input.close();
    }
}

class OddEvenArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.err.println("Invalid natural number.");
            input.close();
            return;
        }

        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];
        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        System.out.println("Odd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.println(oddNumbers[i]);
        }

        System.out.println("Even numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.println(evenNumbers[i]);
        }

        input.close();
    }
}

class FactorsArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == maxFactor) {
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }

                factors[index++] = i;
            }
        }

        System.out.println("Factors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.println(factors[i]);
        }

        input.close();
    }
}

class MatrixToArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];
        int[] array = new int[rows * columns];
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = input.nextInt();
                array[index++] = matrix[i][j];
            }
        }

        System.out.println("One dimensional array:");
        for (int value : array) {
            System.out.println(value);
        }

        input.close();
    }
}

class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.err.println("Invalid positive integer.");
            input.close();
            return;
        }

        String[] results = new String[number + 1];
        for (int i = 0; i <= number; i++) {
            if (i != 0 && i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i != 0 && i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i != 0 && i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        input.close();
    }
}
