package praktikum.sesi5;

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

public class NilaiTester {
    public static void main(String[] args) {
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
    }
}
