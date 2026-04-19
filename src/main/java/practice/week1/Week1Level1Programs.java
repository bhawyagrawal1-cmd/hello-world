package practice.week1;

import java.util.Scanner;

class HarryAge {
    public static void main(String[] args) {
        int birthYear = 2000;
        int currentYear = 2024;
        int age = currentYear - birthYear;

        System.out.println("Harry's age in " + currentYear + " is " + age);
    }
}

class SamAverageMarks {
    public static void main(String[] args) {
        int maths = 94;
        int physics = 95;
        int chemistry = 96;
        double average = (maths + physics + chemistry) / 3.0;

        System.out.println("Sam's average mark in PCM is " + average);
    }
}

class KilometersToMilesFixed {
    public static void main(String[] args) {
        double kilometers = 10.8;
        double kilometersPerMile = 1.6;
        double miles = kilometers / kilometersPerMile;

        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}

class ProfitAndLoss {
    public static void main(String[] args) {
        double costPrice = 129;
        double sellingPrice = 191;
        double profit = sellingPrice - costPrice;
        double profitPercentage = profit / costPrice * 100;

        System.out.println("Cost Price: INR " + costPrice
                + "\nSelling Price: INR " + sellingPrice
                + "\nProfit: INR " + profit
                + "\nProfit Percentage: " + profitPercentage + "%");
    }
}

class PenDistribution {
    public static void main(String[] args) {
        int pens = 14;
        int students = 3;
        int pensPerStudent = pens / students;
        int remainingPens = pens % students;

        System.out.println("The Pen Per Student is " + pensPerStudent
                + " and the remaining pen not distributed is " + remainingPens);
    }
}

class FeeDiscountFixed {
    public static void main(String[] args) {
        double fee = 125000;
        double discountPercent = 10;
        double discount = fee * discountPercent / 100;
        double finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount
                + " and final discounted fee is INR " + finalFee);
    }
}

class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double kilometersPerMile = 1.6;
        double radiusMiles = radiusKm / kilometersPerMile;
        double volumeKm = 4.0 / 3 * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles = 4.0 / 3 * Math.PI * Math.pow(radiusMiles, 3);

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm
                + " and cubic miles is " + volumeMiles);
    }
}

class KilometersToMilesInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double kilometersPerMile = 1.6;

        System.out.print("Enter distance in kilometers: ");
        double kilometers = input.nextDouble();
        double miles = kilometers / kilometersPerMile;

        System.out.println("The total miles is " + miles + " mile for the given " + kilometers + " km");
        input.close();
    }
}

class FeeDiscountInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student fee: ");
        double fee = input.nextDouble();
        System.out.print("Enter discount percentage: ");
        double discountPercent = input.nextDouble();

        double discount = fee * discountPercent / 100;
        double finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount
                + " and final discounted fee is INR " + finalFee);
        input.close();
    }
}

class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double centimetersPerInch = 2.54;
        int inchesPerFoot = 12;

        System.out.print("Enter height in centimeters: ");
        double heightCentimeters = input.nextDouble();
        double totalInches = heightCentimeters / centimetersPerInch;
        int feet = (int) (totalInches / inchesPerFoot);
        double inches = totalInches % inchesPerFoot;

        System.out.println("Your height in cm is " + heightCentimeters
                + " while in feet is " + feet + " and inches is " + inches);
        input.close();
    }
}
