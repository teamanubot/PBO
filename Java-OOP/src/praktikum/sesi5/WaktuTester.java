package praktikum.sesi5;

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

public class WaktuTester {
    public static void main(String[] args) {
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
    }
}
