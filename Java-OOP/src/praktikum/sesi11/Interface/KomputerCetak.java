package praktikum.sesi11.Interface;

public final class KomputerCetak {
    public final void cetak(Komputer[] obj) {
        for (Komputer k : obj) {
            k.hidupkan_os();
            k.klik_kanan();
            k.klik_kiri();
            k.tekan_enter();
            k.cetak_data();
            k.matikan_os();
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {
        Komputer[] perangkat = new Komputer[3];

        perangkat[0] = new PC();
        perangkat[1] = new Laptop();
        perangkat[2] = new Netbook();

        KomputerCetak cetak = new KomputerCetak();
        cetak.cetak(perangkat);
    }
}
