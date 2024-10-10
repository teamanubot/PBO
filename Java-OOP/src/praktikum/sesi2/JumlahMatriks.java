package praktikum.sesi2;

public class JumlahMatriks {
    public static void main(String[] args) {
        int[][] matriks1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int jumlah = 0;
        for (int i = 0; i < matriks1.length; i++) {
            for (int j = 0; j < matriks1[i].length; j++) {
                jumlah += matriks1[i][j];
            }
        }
        System.out.println("Jumlah elemen dalam matriks : " + jumlah);
    }
}
