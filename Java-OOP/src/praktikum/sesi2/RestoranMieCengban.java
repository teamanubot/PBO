package praktikum.sesi2;

import java.util.Scanner;

public class RestoranMieCengban {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] menu = {"Mie Cengban", "Otak Otak", "Es Teh Manis"};
        int[] harga = {15000, 8000, 5000};
        int totalBiaya = 0;
        char ulang;

        System.out.println("Selamat datang di Restoran Mie Cengban!");
        System.out.println("Berikut adalah menu yang tersedia:");

        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + " - Rp " + harga[i]);
        }

        do {
            System.out.print("Pilih nomor menu yang ingin dipesan (1-3): ");
            int pilihan = scanner.nextInt();

            if (pilihan >= 1 && pilihan <= 3) {
                System.out.print("Masukkan jumlah pesanan untuk " + menu[pilihan - 1] + ": ");
                int jumlahPesanan = scanner.nextInt();
                
                totalBiaya += harga[pilihan - 1] * jumlahPesanan;
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }

            System.out.print("Apakah Anda ingin memesan lagi? (y/n): ");
            ulang = scanner.next().charAt(0);

        } while (ulang == 'y' || ulang == 'Y');

        System.out.println("Total biaya pesanan Anda adalah: Rp " + totalBiaya);
        System.out.println("Terima kasih telah memesan di Restoran Mie Cengban!");
        
        scanner.close();
    }
}