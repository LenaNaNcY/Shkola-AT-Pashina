package Lection3Lambda;

import java.util.Scanner;

public class Math {
        public static void main(String[] args) {
            Scanner type = new Scanner(System.in);

            System.out.print("Type variable a: ");
            double a = type.nextDouble();

            System.out.print("Type variable b: ");
            double b = type.nextDouble(); //если не целое, надо формат через запятую

            double n;
            double m;

            if (a >= b) {
                n = java.lang.Math.cbrt(a - b); // Используем метод cbrt() для вычисления кубического корня
                System.out.println("n = " + n);
            } else {
                n = java.lang.Math.pow(a, 2) + ((a - b) / java.lang.Math.sin(a - b));
                System.out.println("n = " + n);
            }

            if (n < b) {
                m = ((n + a) / -b) + java.lang.Math.sqrt((java.lang.Math.pow(java.lang.Math.sin(a), 2) - java.lang.Math.cos(n)));
                System.out.println("m = " + m);
            } else if (n == b) {
                m = java.lang.Math.pow(b, 2) - java.lang.Math.tan(n * a);
//            или преобразуем радианы в градусы? Тогда
//            m = Math.pow(b, 2) - Math.tan(Math.toRadians(n * a));
                System.out.println("m = " + m);
            } else {
                m = java.lang.Math.pow(b, 3) + n * java.lang.Math.pow(a, 2);
                System.out.println("m = " + m);
            }
            System.out.println("Result: n = " + n + " m = " + m);
        }
    }

