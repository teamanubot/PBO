package praktikum.sesi10.Polymorfisme_Dinamis;

public class CetakGambar extends Bentuk {
    private void tampil(Bentuk[] obj) {
        for (Bentuk bentuk : obj) {
            bentuk.gambar();
            bentuk.hapus();
            System.out.println("======================");
        }
    }

    public static void main(String[] args) {
        Bentuk[] obj = {
            new Lingkaran(),
            new Elips(),
            new Lingkaran()
        };

        CetakGambar cetakGambar = new CetakGambar();
        cetakGambar.tampil(obj);
    }
}
