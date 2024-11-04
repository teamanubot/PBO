package praktikum.sesi4;

class Calculator {
    public double operan1;
    public double operan2;

    public void isiOperan1(double x) {
        this.operan1 = x;
    }

    public void isiOperan2(double x) {
        this.operan2 = x;
    }

    public double tambah() {
        return operan1 + operan2;
    }

    public double kurang() {
        return operan1 - operan2;
    }

    public double kali() {
        return operan1 * operan2;
    }

    public double bagi() {
        if (operan2 != 0) {
            return operan1 / operan2;
        } else {
            System.out.println("Error: Division by zero");
            return Double.NaN;
        }
    }

    public double pangkat() {
        return Math.pow(operan1, operan2);
    }
}

public class ClassCalculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.isiOperan1(10.0);
        calc.isiOperan2(4.0);
        System.out.println("Operan1 + Operan2 = " + calc.tambah());
        System.out.println("Operan1 - Operan2 = " + calc.kurang());
        System.out.println("Operan1 * Operan2 = " + calc.kali());
        System.out.println("Operan1 / Operan2 = " + calc.bagi());
        System.out.println("Operan1 ^ Operan2 = " + calc.pangkat());
    }
}
