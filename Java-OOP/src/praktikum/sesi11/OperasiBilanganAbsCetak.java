package praktikum.sesi11;

import java.util.Scanner;

abstract class OperasiBilanganAbs {
    protected double a, b, c;

    protected abstract void set_A(double a);

    protected abstract void set_B(double b);

    protected abstract void set_C();

    protected abstract double get_A();

    protected abstract double get_B();

    protected abstract double get_C();

    protected abstract void tampil();
}

class OperasiPenjumlahan extends OperasiBilanganAbs {

    @Override
    protected void set_A(double a) {
        this.a = a;
    }

    @Override
    protected void set_B(double b) {
        this.b = b;
    }

    @Override
    protected void set_C() {
        this.c = a + b;
    }

    @Override
    protected double get_A() {
        return a;
    }

    @Override
    protected double get_B() {
        return b;
    }

    @Override
    protected double get_C() {
        return c;
    }

    @Override
    protected void tampil() {
        System.out.println("Hasil Penjumlahan " + a + " + " + b + " = " + c);
    }
}

class OperasiPengurangan extends OperasiBilanganAbs {

    @Override
    protected void set_A(double a) {
        this.a = a;
    }

    @Override
    protected void set_B(double b) {
        this.b = b;
    }

    @Override
    protected void set_C() {
        this.c = a - b;
    }

    @Override
    protected double get_A() {
        return a;
    }

    @Override
    protected double get_B() {
        return b;
    }

    @Override
    protected double get_C() {
        return c;
    }

    @Override
    protected void tampil() {
        System.out.println("Hasil Pengurangan " + a + " + " + b + " = " + c);
    }
}

class OperasiPerkalian extends OperasiBilanganAbs {

    @Override
    protected void set_A(double a) {
        this.a = a;
    }

    @Override
    protected void set_B(double b) {
        this.b = b;
    }

    @Override
    protected void set_C() {
        this.c = a * b;
    }

    @Override
    protected double get_A() {
        return a;
    }

    @Override
    protected double get_B() {
        return b;
    }

    @Override
    protected double get_C() {
        return c;
    }

    @Override
    protected void tampil() {
        System.out.println("Hasil Perkalian " + a + " + " + b + " = " + c);
    }
}

class OperasiPembagian extends OperasiBilanganAbs {

    @Override
    protected void set_A(double a) {
        this.a = a;
    }

    @Override
    protected void set_B(double b) {
        this.b = b;
    }

    @Override
    protected void set_C() {
        if (b != 0) {
            this.c = a / b;
        } else {
            System.out.println("Error: Pembagian dengan nol!");
        }
    }

    @Override
    protected double get_A() {
        return a;
    }

    @Override
    protected double get_B() {
        return b;
    }

    @Override
    protected double get_C() {
        return c;
    }

    @Override
    protected void tampil() {
        System.out.println("Hasil Pembagian " + a + " + " + b + " = " + c);
    }
}

final public class OperasiBilanganAbsCetak {
    private void cetakSemua(OperasiBilanganAbs[] OB, double a, double b) {
        for (OperasiBilanganAbs operasi : OB) {
            operasi.set_A(a);
            operasi.set_B(b);
            operasi.set_C();
            operasi.tampil();
        }
    }

    public static void main(String[] args) {
        double A, B;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Nilai A : ");
            A = scan.nextDouble();
            System.out.print("Nilai B : ");
            B = scan.nextDouble();
        }

        OperasiBilanganAbs[] operasi = {
                new OperasiPenjumlahan(),
                new OperasiPengurangan(),
                new OperasiPerkalian(),
                new OperasiPembagian()
        };

        OperasiBilanganAbsCetak cetak = new OperasiBilanganAbsCetak();
        cetak.cetakSemua(operasi, A, B);
    }
}