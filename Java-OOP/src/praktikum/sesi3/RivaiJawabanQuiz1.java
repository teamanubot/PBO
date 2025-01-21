package praktikum.sesi3;

import java.util.Scanner;

public class RivaiJawabanQuiz1 {
    public static void soalNomor1() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan angka : ");
            int angka = input.nextInt();
            if(angka < 0) {
                System.out.println("Angka " + angka + " adalah bilangan negatif");
            } else if(angka > 0) {
                System.out.println("Angka " + angka + " adalah bilangan positif");
            } else if(angka == 0) {
                System.out.println("Angka yang anda masukkan adalah nol");
            } else {
                System.out.println("Anda salah memasukkan angka");
            }
        }
    }

    public static void soalNomor2() {
        int angka = 5, i;
        for(i = 1; i <= angka; i++) {
            System.out.println(i);
        }
    }

    public static void soalNomor3() {
        try (Scanner input = new Scanner(System.in)) {
            int angka;
            do { 
                System.out.print("Masukkan angka : ");
                angka = input.nextInt();
            } while (angka != 0);
            System.out.println("Program telah berakhir");
        }
    }

    public static void soalNomor4() {
        int jumlahGenap = 0, i;
        for(i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                jumlahGenap += 1;
                if(i == 100) {
                    System.out.println(i);
                } else {
                    System.out.println(i + ", ");
                }
            } else {
                System.out.println(i + ", ");
            }
        }
        System.out.println("Jumlah bilangan genap dari 1 sampai 100 adalah " + jumlahGenap);
    }

    public static void soalNomor5() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan batas bawah : ");
            int batasbawah = input.nextInt();
            System.out.print("Masukkan batas atas : ");
            int batasatas = input.nextInt();
            System.out.println("Bilangan genap:");
            for(int i = batasbawah; i <= batasatas; i++) {
                if(i % 2 == 0) {
                    System.out.println(i + " ");
                }
            }
            System.out.println("Bilangan ganjil:");
            for(int i = batasbawah; i <= batasatas; i++) {
                if(i % 2 != 0) {
                    System.out.println(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int pilihan;
        try (Scanner jj = new Scanner(System.in)) {
            System.out.print("Masukkan Menu\n1. Soal Nomor 1\n2. Soal Nomor 2\n3. Soal Nomor 3\n4. Soal Nomor 4\n5. Soal Nomor 5\nPilihan : ");
            pilihan = jj.nextInt();
            switch (pilihan) {
                case 1 -> soalNomor1();
                case 2 -> soalNomor2();
                case 3 -> soalNomor3();
                case 4 -> soalNomor4();
                case 5 -> soalNomor5();
                default -> System.out.println("Pilihan tidak ada");
            }
        }
    }
}