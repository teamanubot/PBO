package praktikum.sesi4;

class Item {
    private String nama;
    private int jumlah;
    private double hargaPerUnit;

    public Item(String nama, int jumlah, double hargaPerUnit) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.hargaPerUnit = hargaPerUnit;
    }
    public void tambahStok(int jumlahTambah) {
        this.jumlah += jumlahTambah;
        System.out.println("Stok " + nama + " bertambah " + jumlahTambah + ". Stok sekarang : " + jumlah);
    }
    public void kurangiStok(int jumlahKurang) {
        if (jumlahKurang <= this.jumlah) {
            this.jumlah -= jumlahKurang;
            System.out.println("Stok " + nama + " berkurang " + jumlahKurang + ". Stok sekarang : " + jumlah);
        } else {
            System.out.println("Stok " + nama + " tidak cukup untuk dikurangi " + jumlahKurang);
        }
    }
    public double hitungNilaiTotal() {
        return jumlah * hargaPerUnit;
    }
    public String getNama() {
        return nama;
    }
    public int getJumlah() {
        return jumlah;
    }
    public double getHargaPerUnit() {
        return hargaPerUnit;
    }
}

class ManajemenInventaris {
    private Item[] items;
    private int jumlahItem;

    public ManajemenInventaris(int kapasitas) {
        items = new Item[kapasitas];
        jumlahItem = 0;
    }

    public void tambahItem(Item item) {
        if (jumlahItem < items.length) {
            items[jumlahItem] = item;
            jumlahItem++;
            System.out.println("Item " + item.getNama() + " berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas inventaris penuh.");
        }
    }

    public double hitungTotalNilaiInventaris() {
        double totalNilai = 0;
        for (int i = 0; i < jumlahItem; i++) {
            totalNilai += items[i].hitungNilaiTotal();
        }
        return totalNilai;
    }

    public void tampilkanInventaris() {
        System.out.println("Daftar Inventaris:");
        for (int i = 0; i < jumlahItem; i++) {
            System.out.println("- " + items[i].getNama() + " : " + items[i].getJumlah() + " unit, Harga per unit : " + items[i].getHargaPerUnit());
        }
    }
}

public class SistemManajemenInventaris {
    public static void main(String[] args) {
        Item item1 = new Item("Smartwatch", 3, 500000);
        Item item2 = new Item("Smartphone", 5, 1000000);

        ManajemenInventaris inventaris = new ManajemenInventaris(5);

        inventaris.tambahItem(item1);
        inventaris.tambahItem(item2);

        inventaris.tampilkanInventaris();

        item1.tambahStok(5);
        item2.kurangiStok(3);

        inventaris.tampilkanInventaris();

        double totalNilai = inventaris.hitungTotalNilaiInventaris();
        System.out.println("Total nilai inventaris : " + totalNilai);
    }
}