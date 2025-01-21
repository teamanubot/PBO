package praktikum.sesi12;

interface Behavior {
    void bergerak();
    void bersuara();
}

abstract class Animal implements Behavior {
    protected String nama, sifat;
    protected int ukuran;

    public Animal() {}

    public Animal(String nama, int ukuran) {
        this.nama = nama;
        this.ukuran = ukuran;
    }

    public void setNama(String nama) { this.nama = nama; }
    public String getNama() { return nama; }

    public void setUkuran(int ukuran) { this.ukuran = ukuran; }
    public int getUkuran() { return ukuran; }

    public void setSifat(String sifat) { this.sifat = sifat; }
    public String getSifat() { return sifat; }

    @Override
    public abstract void bergerak();
    
    @Override
    public abstract void bersuara();
}

class Mamalia extends Animal {
    private String jenisMamalia;
    private boolean bisaJalan;
    private int jumlahKaki;

    public Mamalia() {}

    public Mamalia(String nama, int ukuran) {
        super(nama, ukuran);
    }

    public void setBisaJalan(boolean bisaJalan) { this.bisaJalan = bisaJalan; }
    public boolean getBisaJalan() { return bisaJalan; }

    public void setJumlahKaki(int jumlahKaki) { this.jumlahKaki = jumlahKaki; }
    public int getJumlahKaki() { return jumlahKaki; }

    public void setJenisMamalia(String jenisMamalia) { this.jenisMamalia = jenisMamalia; }
    public String getJenisMamalia() { return jenisMamalia; }

    @Override
    public void bergerak() {
        System.out.println(nama + " berjalan dengan " + jumlahKaki + " kaki.");
    }

    @Override
    public void bersuara() {
        System.out.println(nama + " mengeluarkan suara Mamalia.");
    }
}

class Aves extends Animal {
    private String jenisAves;
    private boolean bisaTerbang;

    public Aves() {}

    public Aves(String nama, int ukuran) {
        super(nama, ukuran);
    }

    public void setBisaTerbang(boolean bisaTerbang) { this.bisaTerbang = bisaTerbang; }
    public boolean getBisaTerbang() { return bisaTerbang; }

    public void setJenisAves(String jenisAves) { this.jenisAves = jenisAves; }
    public String getJenisAves() { return jenisAves; }

    @Override
    public void bergerak() {
        if (bisaTerbang) {
            System.out.println(nama + " sedang terbang di langit.");
        } else {
            System.out.println(nama + " berjalan di darat.");
        }
    }

    @Override
    public void bersuara() {
        System.out.println(nama + " berkicau.");
    }
}

class Ayam extends Aves {
    private String jenisAyam;
    private boolean bisaDiadu;

    public Ayam() {}

    public Ayam(String nama, int ukuran) {
        super(nama, ukuran);
    }

    public void setJenisAyam(String jenisAyam) { this.jenisAyam = jenisAyam; }
    public String getJenisAyam() { return jenisAyam; }

    public void setBisaDiadu(boolean bisaDiadu) { this.bisaDiadu = bisaDiadu; }
    public boolean getBisaDiadu() { return bisaDiadu; }

    @Override
    public void bergerak() {
        System.out.println(getNama() + " ayam berjalan dan berkokok.");
    }

    @Override
    public void bersuara() {
        System.out.println(getNama() + " berkokok keras: Kukuruyuk!");
    }
}

class Merpati extends Aves {

    public Merpati() {}

    public Merpati(String nama, int ukuran) {
        super(nama, ukuran);
        super.setBisaTerbang(true);
    }

    @Override
    public void bergerak() {
        System.out.println(getNama() + " terbang dengan anggun.");
    }

    @Override
    public void bersuara() {
        System.out.println(getNama() + " bersuara: Koo... Koo...");
    }
}

public class AnimalTester {
    public static void main(String[] args) {
        Mamalia kucing = new Mamalia("Kucing", 10);
        kucing.setJumlahKaki(4);
        kucing.bergerak();
        kucing.bersuara();

        Ayam ayamKampung = new Ayam("Ayam Kampung", 15);
        ayamKampung.setBisaDiadu(true);
        ayamKampung.bergerak();
        ayamKampung.bersuara();

        Merpati merpatiPutih = new Merpati("Merpati Putih", 12);
        merpatiPutih.bergerak();
        merpatiPutih.bersuara();
    }
}