package org.example.lesson4;

public class Triangle {
    public static void main(String[] args) throws NumberIsNegative {
        System.out.printf("Площадь %.2f",isTriangle(14, 12, 12));
    }
    public static double isTriangle(double a, double b, double c) throws NumberIsNegative {
        if (a < 0 || b < 0 || c < 0){
            throw new NumberIsNegative("IsNegative");
        }
        double p = (a + b + c)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
