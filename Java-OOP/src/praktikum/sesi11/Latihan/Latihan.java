package praktikum.sesi11.Latihan;

/*

*Buatlah program Java untuk manajemen kendaraan dengan fitur-fitur berikut:

- Abstract Class:
Gunakan abstract class Kendaraan yang memiliki atribut dan method dasar untuk semua kendaraan.

- Interface:
Buat tiga interface Mesin, Penumpang, dan FiturTambahan yang harus diimplementasikan oleh kendaraan tertentu.

- Final Class:
Final class CetakKendaraan digunakan untuk mencetak detail dari semua jenis kendaraan.

- Polimorfisme:
Tampilkan kemampuan kendaraan melalui polimorfisme menggunakan abstract class dan interface.

- Jenis Kendaraan:
Mobil, Motor, dan Bus adalah subclass dari Kendaraan yang mengimplementasikan method sesuai kebutuhan.

*Program harus memiliki fitur:

 Fungsi Mesin: Semua kendaraan dapat dihidupkan dan dimatikan mesinnya.
Manajemen Penumpang: Atur jumlah penumpang maksimum.

- Fitur Tambahan: Beberapa kendaraan memiliki fitur tambahan, seperti AC, WiFi, atau GPS.
Polimorfisme: Semua kendaraan harus dikelola dalam satu array dan diproses menggunakan loop.

 */

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

class MusicPlayer {
    public static void playMusic(String filePath) {
        try {
            File musicPath = new File(filePath);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);

                clip.start();
                System.out.println("Lagu sedang diputar... Tekan Enter untuk berhenti.");
                System.in.read();
                clip.stop();
            } else {
                System.out.println("File lagu tidak ditemukan: " + filePath);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Terjadi kesalahan saat memutar lagu: " + e.getMessage());
        }
    }
}

interface Mesin {
   void hidupkanMesin();
   void matikanMesin();
}

interface Penumpang {
    void aturPenumpang(int jumlah);
    int getJumlahPenumpang();
}

interface FiturTambahan {
    void fiturTambahan();
}

abstract class Kendaraan implements Mesin, Penumpang {
    protected String nama;
    protected int kapasitasMesin;
    protected int penumpang;

    public Kendaraan(String nama, int kapasitasMesin) {
        this.nama = nama;
        this.kapasitasMesin = kapasitasMesin;
    }

    public abstract void infoKendaraan();
}

class Mobil extends Kendaraan implements FiturTambahan {
    private final boolean AC;

    public Mobil(String nama, int kapasitasMesin, boolean AC) {
        super(nama, kapasitasMesin);
        this.AC = AC;
    }

    @Override
    public void hidupkanMesin() {
        System.out.println(nama + " (Mobil): Mesin dihidupkan");
    }

    @Override
    public void matikanMesin() {
        System.out.println(nama + " (Mobil): Mesin dimatikan");
    }

    @Override
    public void aturPenumpang(int jumlah) {
        this.penumpang = jumlah;
    }

    @Override
    public int getJumlahPenumpang() {
        return penumpang;
    }

    @Override
    public void fiturTambahan() {
        if (AC) {
            System.out.println(nama + ": AC menyala");
        } else {
            System.out.println(nama + ": AC tidak tersedia");
        }
    }

    @Override
    public void infoKendaraan() {
        System.out.println("Mobil: " + nama + ", Kapasitas Mesin: " + kapasitasMesin + "cc, Penumpang: " + penumpang);
    }
}

class Motor extends Kendaraan {
    public Motor(String nama, int kapasitasMesin) {
        super(nama, kapasitasMesin);
    }

    @Override
    public void hidupkanMesin() {
        System.out.println(nama + " (Motor): Mesin dihidupkan");
    }

    @Override
    public void matikanMesin() {
        System.out.println(nama + " (Motor): Mesin dimatikan");
    }

    @Override
    public void aturPenumpang(int jumlah) {
        if (jumlah > 2) {
            System.out.println(nama + " (Motor): Penumpang melebihi kapasitas!");
            this.penumpang = 2;
        } else {
            this.penumpang = jumlah;
        }
    }

    @Override
    public int getJumlahPenumpang() {
        return penumpang;
    }

    @Override
    public void infoKendaraan() {
        System.out.println("Motor: " + nama + ", Kapasitas Mesin: " + kapasitasMesin + "cc, Penumpang: " + penumpang);
    }
}

class Bus extends Kendaraan implements FiturTambahan {
    private final boolean WiFi;

    public Bus(String nama, int kapasitasMesin, boolean WiFi) {
        super(nama, kapasitasMesin);
        this.WiFi = WiFi;
    }

    @Override
    public void hidupkanMesin() {
        System.out.println(nama + " (Bus): Mesin dihidupkan");
    }

    @Override
    public void matikanMesin() {
        System.out.println(nama + " (Bus): Mesin dimatikan");
    }

    @Override
    public void aturPenumpang(int jumlah) {
        this.penumpang = jumlah;
    }

    @Override
    public int getJumlahPenumpang() {
        return penumpang;
    }

    @Override
    public void fiturTambahan() {
        if (WiFi) {
            System.out.println(nama + ": WiFi tersedia");
        } else {
            System.out.println(nama + ": WiFi tidak tersedia");
        }
    }

    @Override
    public void infoKendaraan() {
        System.out.println("Bus: " + nama + ", Kapasitas Mesin: " + kapasitasMesin + "cc, Penumpang: " + penumpang);
    }
}

final class CetakKendaraan {
    public final void cetak(Kendaraan[] listKendaraan) {
        for (Kendaraan k : listKendaraan) {
            k.hidupkanMesin();
            k.infoKendaraan();
            k.matikanMesin();
            if (k instanceof FiturTambahan fiturTambahan) {
                fiturTambahan.fiturTambahan();
            }
            System.out.println("--------------------------");
        }
    }
}

public class Latihan {
    public static void main(String[] args) {
        Kendaraan[] kendaraan = new Kendaraan[3];

        kendaraan[0] = new Mobil("Toyota Fortuner", 2400, true);
        kendaraan[0].aturPenumpang(5);

        kendaraan[1] = new Motor("Yamaha R15", 155);
        kendaraan[1].aturPenumpang(2);

        kendaraan[2] = new Bus("Sinar Jaya", 6000, true);
        kendaraan[2].aturPenumpang(30);

        CetakKendaraan cetak = new CetakKendaraan();
        cetak.cetak(kendaraan);
        MusicPlayer.playMusic("/root/perkuliahan/PBO/Java-OOP/src/praktikum/sesi11/Latihan/rapsodi.wav");
    }
}
