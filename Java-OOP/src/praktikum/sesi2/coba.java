package praktikum.sesi2;

import java.util.Scanner;

public class coba {
    public static void main(String[] args) {
        String password = "Rivai Ganteng";
        Scanner scn = new Scanner(System.in);
        args = new String[1];
        System.out.print("Ketik passnya : ");
        args[0] = scn.nextLine();
        if (args[0].equals(password)) {
            System.out.println("Criorrect!");
        } else {
            System.out.println("Incorrect!");
        }
    }
}
