package praktikum.sesi5;

import java.util.Scanner;

class Mahasiswa {
    public String nama;
    public int usia;
    private String jurusan;

    public Mahasiswa(String nama, int usia, String jurusan) {
        this.nama = nama;
        this.usia = usia;
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusanBaru) {
        this.jurusan = jurusanBaru;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia);
        System.out.println("Jurusan: " + jurusan);
    }
}

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

class Nilai {
    private double quis;
    private double uts;
    private double uas;

    public void setQuis(double quis) {
        this.quis = quis;
    }

    public void setUTS(double uts) {
        this.uts = uts;
    }

    public void setUAS(double uas) {
        this.uas = uas;
    }

    public double Quis() {
        return quis;
    }

    public double UTS() {
        return uts;
    }

    public double UAS() {
        return uas;
    }

    public double getNA() {
        return (0.2 * quis) + (0.3 * uts) + (0.5 * uas);
    }

    public char getIndex() {
        double na = getNA();
        if (na >= 80 && na <= 100) {
            return 'A';
        } else if (na >= 68 && na < 80) {
            return 'B';
        } else if (na >= 56 && na < 68) {
            return 'C';
        } else if (na >= 45 && na < 56) {
            return 'D';
        } else {
            return 'E';
        }
    }

    public String getKeterangan() {
        char index = getIndex();
        switch (index) {
            case 'A':
                return "Sangat Baik";
            case 'B':
                return "Baik";
            case 'C':
                return "Cukup";
            case 'D':
                return "Kurang";
            case 'E':
                return "Sangat Kurang";
            default:
                return "Tidak Valid";
        }
    }
}

class Siswa {
    private String nama;
    private int nilaiUjian;

    public Siswa(String nama, int nilaiUjian) {
        this.nama = nama;
        setNilaiUjian(nilaiUjian);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNilaiUjian() {
        return nilaiUjian;
    }

    public void setNilaiUjian(int nilaiUjian) {
        if (nilaiUjian >= 0 && nilaiUjian <= 100) {
            this.nilaiUjian = nilaiUjian;
        } else {
            System.out.println("Nilai ujian harus di antara 0 dan 100.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama : " + nama);
        System.out.println("Nilai Ujian : " + nilaiUjian);
    }
}

class Waktu {
    private int menitWaktu;

    public void setJam(int j) {
        this.menitWaktu = j * 60;
    }

    public void setMenit(int m) {
        this.menitWaktu += m;
    }

    public void tambahJam(int j) {
        this.menitWaktu += j * 60;
    }

    public void tambahMenit(int m) {
        this.menitWaktu += m;
    }

    public void tambahWaktu(int j, int m) {
        this.menitWaktu += (j * 60) + m;
    }

    public int getTotalMenit() {
        return menitWaktu;
    }

    public int getJam() {
        return menitWaktu / 60;
    }

    public int getMenit() {
        return menitWaktu % 60;
    }

    public void tampilWaktu() {
        int jam = getJam();
        int menit = getMenit();
        System.out.println("Waktu : " + jam + ":" + menit);
    }
}

public class Sesi5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Pilih menu:");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Mobil");
            System.out.println("3. Nilai");
            System.out.println("4. Siswa");
            System.out.println("5. Waktu");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    Mahasiswa mahasiswa1 = new Mahasiswa("Rivai", 22, "Teknik Informatika");
                    System.out.println("Nama Mahasiswa : " + mahasiswa1.nama);
                    System.out.println("Usia Mahasiswa : " + mahasiswa1.usia);
                    System.out.println("Jurusan Mahasiswa : " + mahasiswa1.getJurusan());
                    mahasiswa1.setJurusan("Sistem Informasi");
                    System.out.println("Jurusan Mahasiswa : " + mahasiswa1.getJurusan());
                    mahasiswa1.tampilkanInfo();
                    break;
                case 2:
                    Mobil mobil1 = new Mobil("Toyota", 2022, 300000000L);
                    System.out.println("Merk Mobil : " + mobil1.merk);
                    System.out.println("Tahun Produksi Mobil : " + mobil1.tahunProduksi);
                    System.out.println("Harga Mobil : " + mobil1.getHarga());
                    mobil1.setHarga(350000000L);
                    System.out.println("Harga Mobil Setelah Diubah : " + mobil1.getHarga());
                    mobil1.tampilkanInfo();
                    break;
                case 3:
                    Nilai n = new Nilai();
                    n.setQuis(60);
                    n.setUTS(80);
                    n.setUAS(75);
                    System.out.println("Quis : " + n.Quis());
                    System.out.println("UTS : " + n.UTS());
                    System.out.println("UAS : " + n.UAS());
                    System.out.println("Nilai Akhir : " + n.getNA());
                    System.out.println("Index : " + n.getIndex());
                    System.out.println("Keterangan : " + n.getKeterangan());
                    break;
                case 4:
                    Siswa siswa1 = new Siswa("Budi", 85);
                    siswa1.tampilkanInfo();
                    siswa1.setNama("Rivai");
                    siswa1.setNilaiUjian(95);
                    System.out.println("\nSetelah Diubah : ");
                    siswa1.tampilkanInfo();
                    siswa1.setNilaiUjian(105);
                    break;
                case 5:
                    Waktu w = new Waktu();
                    System.out.println("1. Total Menit : " + w.getTotalMenit());
                    w.setJam(10);
                    System.out.println("2. Total Menit : " + w.getTotalMenit());
                    w.setMenit(57);
                    System.out.println("3. Total Menit : " + w.getTotalMenit());
                    w.tampilWaktu();
                    w.tambahJam(7);
                    System.out.println("4. JAM : " + w.getJam() + " MENIT : " + w.getMenit());
                    w.tambahMenit(40);
                    System.out.println("5. JAM : " + w.getJam() + " MENIT : " + w.getMenit());
                    w.tampilWaktu();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        }
    }
}