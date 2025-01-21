package praktikum.sesi2;

import java.util.Scanner;

public class HitungRataRata {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int jumlahNilai = 0;
            double totalNilai = 0;
            char lanjut;
            do {
                System.out.print("Masukkan nilai : ");
                double nilai = input.nextDouble();
                totalNilai += nilai;
                jumlahNilai++;
                System.out.print("Apakah anda ingin memasukkan nilai lagi? (y/n) : ");
                lanjut = input.next().charAt(0);
            } while (lanjut == 'y' || lanjut == 'Y');
            double rataRata = totalNilai / jumlahNilai;
            System.out.println("Rata-rata nilai : " + rataRata);
        }
    }
}
