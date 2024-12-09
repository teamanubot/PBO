package praktikum.sesi9.pegawai;

public class Kasir extends Pegawai {
    @Override

    public void menampilkan() {
        System.out.println("Nama : " + nama);
        System.out.println("ID Pegawai : " + id_pegawai);
        System.out.println("Gaji : " + gaji);
    }

    public void tugas() {
        System.out.println("Tugas : Melakukan transaksi dengan pembeli");
        System.out.println("----------------------------------------------");
    }
}
