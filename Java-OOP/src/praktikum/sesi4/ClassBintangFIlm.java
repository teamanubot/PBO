package praktikum.sesi4;

class BintangFIlm {
    private final String nama;
    private final boolean pria;
    BintangFIlm(String nama, boolean pria) {
        this.nama = nama;
        this.pria = pria;
    }
    String perolehNama() {
        return nama;
    }
    String perolehJenisKelamin() {
        if (pria) {
            return "Pria";
        } else {
            return "Wanita";
        }
    }
}

public class ClassBintangFIlm {
    public static void main(String[] args) {
        BintangFIlm siA = new BintangFIlm("Budi", true);
        BintangFIlm siB = new BintangFIlm("Hani", false);
        System.out.println("siA => " + siA.perolehNama() + ", " + siA.perolehJenisKelamin());
        System.out.println("siB => " + siB.perolehNama() + ", " + siB.perolehJenisKelamin());
    }
}