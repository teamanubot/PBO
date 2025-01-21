package praktikum.sesi2;

import java.util.Scanner;

public class LampuLaluLintas {
    public static void main(String[] args) {
        String lampu;
        Scanner scan = new Scanner(System.in);
        System.out.print("Inputkan nama warna : ");
        lampu = scan.nextLine();
        switch (lampu) {
            case "merah" -> System.out.println("Lampu merah, berhenti!");
            case "kuning" -> System.out.println("Lampu kuning, harap hati-hati!");
            case "hijau" -> System.out.println("Lampu hijau, silahkan jalan!");
            default -> {
                System.out.println("Warna lampu salah!");
                scan.close();
            }
        }
    }
}
