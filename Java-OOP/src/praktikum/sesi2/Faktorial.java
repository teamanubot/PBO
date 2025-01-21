package praktikum.sesi2;

import java.util.Scanner;

public class Faktorial {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan sebuah angka : ");
            int angka = input.nextInt();
            int faktorial = 1;
            int i = angka;
            while (i > 0) {
                faktorial *= i;
                i--;
            }
            System.out.println("Faktorial dari " + angka + " adalah " + faktorial);
        }
    }
}