package praktikum.sesi5;

class Mobil {
    public String merk;
    protected int tahunProduksi;
    private long harga; 

    public Mobil(String merk, int tahunProduksi, long harga) {
        this.merk = merk;
        this.tahunProduksi = tahunProduksi;
        this.harga = harga;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long hargaBaru) {
        if (hargaBaru > 0) {
            harga = hargaBaru;
        } else {
            System.out.println("Harga harus positif.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Merk : " + merk);
        System.out.println("Tahun Produksi : " + tahunProduksi);
        System.out.println("Harga : " + harga);
    }
}

public class MobilCek {
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil("Toyota", 2022, 300000000L);
        System.out.println("Merk Mobil : " + mobil1.merk);
        System.out.println("Tahun Produksi Mobil : " + mobil1.tahunProduksi);
        System.out.println("Harga Mobil : " + mobil1.getHarga());
        mobil1.setHarga(350000000L);
        System.out.println("Harga Mobil Setelah Diubah : " + mobil1.getHarga());
        mobil1.tampilkanInfo();
    }
}
