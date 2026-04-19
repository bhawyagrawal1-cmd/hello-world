package practice.arrays.level2;

import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        for (int i = 0; i < salaries.length; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double salary = input.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double years = input.nextDouble();

            if (salary <= 0 || years < 0) {
                System.err.println("Invalid input. Enter this employee again.");
                i--;
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = years;
        }

        for (int i = 0; i < salaries.length; i++) {
            double bonusPercent = yearsOfService[i] > 5 ? 5 : 2;
            bonuses[i] = salaries[i] * bonusPercent / 100;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
        input.close();
    }
}

class YoungestTallestFriends {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[names.length];
        double[] heights = new double[names.length];
        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = input.nextDouble();
        }

        for (int i = 1; i < names.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("Youngest friend is " + names[youngestIndex]);
        System.out.println("Tallest friend is " + names[tallestIndex]);
        input.close();
    }
}

class LargestDigitsLimited {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        System.out.print("Enter a number: ");
        long number = Math.abs(input.nextLong());

        while (number != 0 && index < maxDigit) {
            digits[index++] = (int) (number % 10);
            number /= 10;
        }

        printLargestAndSecondLargest(digits, index);
        input.close();
    }

    static void printLargestAndSecondLargest(int[] digits, int count) {
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < count; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}

class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        System.out.print("Enter a number: ");
        long number = Math.abs(input.nextLong());

        while (number != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }

            digits[index++] = (int) (number % 10);
            number /= 10;
        }

        LargestDigitsLimited.printLargestAndSecondLargest(digits, index);
        input.close();
    }
}

class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = Math.abs(input.nextLong());
        long temp = number;
        int count = (number == 0) ? 1 : 0;

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        int[] reverseDigits = new int[count];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (int) (number % 10);
            reverseDigits[i] = digits[i];
            number /= 10;
        }

        System.out.print("Reversed number: ");
        for (int digit : reverseDigits) {
            System.out.print(digit);
        }
        System.out.println();
        input.close();
    }
}

class BmiArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int persons = input.nextInt();
        double[] weights = new double[persons];
        double[] heights = new double[persons];
        double[] bmi = new double[persons];
        String[] statuses = new String[persons];

        for (int i = 0; i < persons; i++) {
            System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
            weights[i] = input.nextDouble();
            System.out.print("Enter height in cm for person " + (i + 1) + ": ");
            heights[i] = input.nextDouble();

            if (weights[i] <= 0 || heights[i] <= 0) {
                System.err.println("Invalid input. Enter this person again.");
                i--;
            }
        }

        for (int i = 0; i < persons; i++) {
            double heightMeters = heights[i] / 100;
            bmi[i] = weights[i] / (heightMeters * heightMeters);
            statuses[i] = bmiStatus(bmi[i]);
        }

        printBmiTable(weights, heights, bmi, statuses);
        input.close();
    }

    static String bmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    static void printBmiTable(double[] weights, double[] heights, double[] bmi, String[] statuses) {
        for (int i = 0; i < weights.length; i++) {
            System.out.println("Person " + (i + 1) + ": height=" + heights[i]
                    + " cm, weight=" + weights[i] + " kg, BMI=" + bmi[i]
                    + ", status=" + statuses[i]);
        }
    }
}

class BmiTwoDimensionalArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int persons = input.nextInt();
        double[][] personData = new double[persons][3];
        String[] weightStatus = new String[persons];

        for (int i = 0; i < persons; i++) {
            System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
            personData[i][0] = input.nextDouble();
            System.out.print("Enter height in cm for person " + (i + 1) + ": ");
            personData[i][1] = input.nextDouble();

            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.err.println("Invalid input. Enter this person again.");
                i--;
            }
        }

        for (int i = 0; i < persons; i++) {
            double heightMeters = personData[i][1] / 100;
            personData[i][2] = personData[i][0] / (heightMeters * heightMeters);
            weightStatus[i] = BmiArray.bmiStatus(personData[i][2]);
        }

        for (int i = 0; i < persons; i++) {
            System.out.println("Person " + (i + 1) + ": height=" + personData[i][1]
                    + " cm, weight=" + personData[i][0] + " kg, BMI=" + personData[i][2]
                    + ", status=" + weightStatus[i]);
        }
        input.close();
    }
}

class StudentGradesArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = input.nextInt();
        int[] physics = new int[students];
        int[] chemistry = new int[students];
        int[] maths = new int[students];
        double[] percentages = new double[students];
        String[] grades = new String[students];

        for (int i = 0; i < students; i++) {
            System.out.print("Enter physics, chemistry, and maths marks for student " + (i + 1) + ": ");
            physics[i] = input.nextInt();
            chemistry[i] = input.nextInt();
            maths[i] = input.nextInt();
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.err.println("Invalid marks. Enter this student again.");
                i--;
            }
        }

        for (int i = 0; i < students; i++) {
            percentages[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            grades[i] = gradeForPercentage(percentages[i]);
            System.out.println("Student " + (i + 1) + ": Physics=" + physics[i]
                    + ", Chemistry=" + chemistry[i] + ", Maths=" + maths[i]
                    + ", Percentage=" + percentages[i] + ", Grade=" + grades[i]);
        }
        input.close();
    }

    static String gradeForPercentage(double percentage) {
        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        }
        return "R";
    }
}

class StudentGradesTwoDimensionalArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = input.nextInt();
        int[][] marks = new int[students][3];
        double[] percentages = new double[students];
        String[] grades = new String[students];

        for (int i = 0; i < students; i++) {
            System.out.print("Enter physics, chemistry, and maths marks for student " + (i + 1) + ": ");
            for (int j = 0; j < marks[i].length; j++) {
                marks[i][j] = input.nextInt();
                if (marks[i][j] < 0) {
                    System.err.println("Invalid marks. Enter this student again.");
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < students; i++) {
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            grades[i] = StudentGradesArray.gradeForPercentage(percentages[i]);
            System.out.println("Student " + (i + 1) + ": Physics=" + marks[i][0]
                    + ", Chemistry=" + marks[i][1] + ", Maths=" + marks[i][2]
                    + ", Percentage=" + percentages[i] + ", Grade=" + grades[i]);
        }
        input.close();
    }
}

class DigitFrequencyArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = Math.abs(input.nextLong());
        int[] frequency = digitFrequency(number);

        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Frequency of " + i + " = " + frequency[i]);
        }
        input.close();
    }

    static int[] digitFrequency(long number) {
        int[] frequency = new int[10];
        if (number == 0) {
            frequency[0] = 1;
            return frequency;
        }

        while (number > 0) {
            int digit = (int) (number % 10);
            frequency[digit]++;
            number /= 10;
        }
        return frequency;
    }
}
