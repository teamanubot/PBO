package praktikum.sesi2;

import java.util.Scanner;

public class Kasir {
    public static void main(String[] args) {
        int belanja, diskon, bayar;
        String kartu;
        Scanner scan = new Scanner(System.in);
        System.out.print("Apakah ada kartu member : ");
        kartu = scan.nextLine();
        System.out.print("Total belanja : ");
        belanja = scan.nextInt();
        if (kartu.equalsIgnoreCase("ya")) {
            if (belanja > 500000) {
                diskon = 50000;
            } else if (belanja > 100000) {
                diskon = 15000;
            } else {
                diskon = 0;
            }
        } else {
            if (belanja > 100000) {
                diskon = 5000;
            } else {
                diskon = 0;
                scan.close();
            }
        }
        bayar = belanja - diskon;
        System.out.println("Total bayar : Rp " + bayar);
    }
}
