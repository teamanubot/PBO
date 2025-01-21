package praktikum.sesi12;

interface Transportasi {
    int IDZ = 0;

    void tampil();
    void setData();
    int getId();
}

class Gojek implements Transportasi {
    protected int harga = 10000;
    protected int id = 1;

    @Override
    public void tampil() {
        System.out.println("ID Gojek: " + id);
        System.out.println("Harga: " + harga);
    }

    @Override
    public void setData() {
        this.id = 1;
        this.harga = 10000;
    }

    @Override
    public int getId() {
        return id;
    }
}

class Bayar extends Gojek {
    private int jarak;  
    private int total;
    private String nama;

    public Bayar(int id) {
        this.id = id;
        this.jarak = 2;
        this.nama = "Budi";
        this.total = jarak * harga;
    }

    public Bayar() {
        super.getId();
        this.jarak = 2;
        this.nama = "Jarez";
        this.total = jarak * harga;
    }

    @Override
    public void tampil() {
        System.out.println("ID: " + getId());
        System.out.println("Nama: " + nama);
        System.out.println("Jarak: " + jarak + " km");
        System.out.println("Total Bayar: Rp " + total);
    }

    @Override
    public void setData() {
        super.setData();
        this.jarak = 2;
        this.nama = "Iqbal";
        this.total = jarak * harga;
    }
}

public class GojekTester {
    public static void main(String[] args) {
        Gojek gojek = new Gojek();
        gojek.setData();
        System.out.println("=== Data Gojek ===");
        gojek.tampil();

        System.out.println();

        Bayar bayar = new Bayar();
        bayar.setData();
        System.out.println("=== Data Bayar ===");
        bayar.tampil();
    }
}
