package praktikum.sesi2;

public class PolaSegitigaTerbalik {
    public static void main(String[] args) {
        int tinggi = 5;
        for (int i = tinggi; i >= 1; i--) {
            for (int j = tinggi; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k < (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
