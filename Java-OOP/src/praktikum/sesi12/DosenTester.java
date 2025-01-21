package praktikum.sesi12;

class Dosen {
    private final String nik;
    private final String nama;

    public Dosen(String nik, String nama) {
        this.nik = nik;
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public String getNama() {
        return nama;
    }

    public void view() {
        System.out.println("NIK: " + nik);
        System.out.println("Nama: " + nama);
    }
}

class Rektor extends Dosen {
    private final int tahunMasuk;

    public Rektor(String nik, String nama, int tahunMasuk) {
        super(nik, nama);
        this.tahunMasuk = tahunMasuk;
    }

    public int getTahunMasuk() {
        return tahunMasuk;
    }

    public void viewRektor() {
        super.view();
        System.out.println("Tahun Masuk: " + tahunMasuk);
    }
}

class Dekan extends Dosen {
    private final String fakultas;

    public Dekan(String nik, String nama, String fakultas) {
        super(nik, nama);
        this.fakultas = fakultas;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void viewDekan() {
        super.view();
        System.out.println("Fakultas: " + fakultas);
    }
}

public class DosenTester {
    public static void main(String[] args) {
        Dosen dosen = new Dosen("232345", "Rivai S.kom., M.kom.");
        System.out.println("Data Dosen :");
        dosen.view();

        System.out.println();

        Rektor rektor = new Rektor("12345", "Prof. Budi", 2020);
        System.out.println("Data Rektor:");
        rektor.viewRektor();

        System.out.println();

        Dekan dekan = new Dekan("67890", "Dr. Sari", "Teknik");
        System.out.println("Data Dekan:");
        dekan.viewDekan();
    }
}
