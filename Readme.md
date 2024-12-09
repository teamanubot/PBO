# Apa itu Java?

Java adalah bahasa pemrograman tingkat tinggi yang dikembangkan oleh Sun Microsystems pada tahun 1995 dan sekarang dimiliki oleh Oracle Corporation. Java dirancang untuk memiliki sedikit ketergantungan implementasi, yang berarti bahwa kode yang ditulis dalam Java dapat dijalankan di berbagai platform tanpa perlu diubah. Ini dikenal dengan prinsip "Write Once, Run Anywhere" (WORA).

Java digunakan secara luas dalam pengembangan aplikasi web, aplikasi desktop, aplikasi mobile (terutama Android), dan aplikasi enterprise. Java juga digunakan dalam pengembangan perangkat lunak untuk perangkat embedded dan sistem real-time.

Beberapa fitur utama Java meliputi:

- **Platform-independen**: Java menggunakan Java Virtual Machine (JVM) untuk menjalankan program, yang memungkinkan kode Java berjalan di berbagai platform tanpa perubahan.
- **Object-Oriented**: Java mendukung konsep pemrograman berorientasi objek, yang membantu dalam pengorganisasian kode dan meningkatkan kemampuan pemeliharaan.
- **Keamanan**: Java memiliki fitur keamanan yang kuat, termasuk manajemen memori otomatis dan pengecekan tipe data pada saat kompilasi.
- **Multithreading**: Java mendukung pemrograman multithreading, yang memungkinkan eksekusi beberapa thread secara bersamaan untuk meningkatkan kinerja aplikasi.
- **Garbage Collection**: Java secara otomatis mengelola memori dengan menghapus objek yang tidak lagi digunakan melalui proses garbage collection.

# Apa itu Java OOP (Object-Oriented Programming)?

Pemrograman Berorientasi Objek (Object-Oriented Programming atau OOP) adalah paradigma pemrograman yang menggunakan "objek" untuk merepresentasikan data dan metode yang beroperasi pada data tersebut. Java adalah bahasa pemrograman yang sepenuhnya mendukung OOP. Berikut adalah konsep-konsep utama dalam OOP:

1. **Kelas (Class)**:
   Kelas adalah blueprint atau cetak biru dari objek. Kelas mendefinisikan atribut (variabel) dan metode (fungsi) yang dimiliki oleh objek. Sebagai contoh, kelas `Mobil` mungkin memiliki atribut seperti `warna`, `merk`, dan `model`, serta metode seperti `berjalan()` dan `berhenti()`.

   ```java
   public class Mobil {
       String warna;
       String merk;
       String model;

       void berjalan() {
           System.out.println("Mobil berjalan");
       }

       void berhenti() {
           System.out.println("Mobil berhenti");
       }
   }
   ```

   **Objek (Object)**: Objek adalah instance dari kelas. Objek memiliki keadaan (state) dan perilaku (behavior) yang ditentukan oleh kelasnya. Sebagai contoh, objek mobil1 adalah instance dari kelas Mobil.

   ```java
   Mobil mobil1 = new Mobil();
   mobil1.warna = "Merah";
   mobil1.merk = "Toyota";
   mobil1.model = "Corolla";
   mobil1.berjalan();
   ```

2. **Enkapsulasi (Encapsulation)**: Enkapsulasi adalah konsep menyembunyikan detail implementasi dari pengguna dan hanya mengekspos fungsionalitas yang diperlukan. Ini dicapai dengan menggunakan modifier akses seperti `private`, `protected`, dan `public`.

   ```java
   public class Mobil {
       private String warna;
       private String merk;
       private String model;

       public String getWarna() {
           return warna;
       }

       public void setWarna(String warna) {
           this.warna = warna;
       }

       // Metode getter dan setter lainnya
   }
   ```

3. **Pewarisan (Inheritance)**: Pewarisan adalah mekanisme di mana satu kelas dapat mewarisi atribut dan metode dari kelas lain. Kelas yang mewarisi disebut subclass, dan kelas yang diwarisi disebut superclass. Pewarisan memungkinkan penggunaan kembali kode dan memperluas fungsionalitas kelas.

   ```java
   public class MobilSport extends Mobil {
       private int kecepatanMaksimum;

       public int getKecepatanMaksimum() {
           return kecepatanMaksimum;
       }

       public void setKecepatanMaksimum(int kecepatanMaksimum) {
           this.kecepatanMaksimum = kecepatanMaksimum;
       }
   }
   ```

4. **Polimorfisme (Polymorphism)**: Polimorfisme adalah kemampuan objek untuk mengambil banyak bentuk. Ini memungkinkan metode yang sama untuk dipanggil pada objek yang berbeda dan berperilaku sesuai dengan kelas objek tersebut. Polimorfisme dapat dicapai melalui overriding dan overloading.

   ```java
   public class Mobil {
       void berjalan() {
           System.out.println("Mobil berjalan");
       }
   }

   public class MobilSport extends Mobil {
       @Override
       void berjalan() {
           System.out.println("Mobil sport berjalan dengan cepat");
       }
   }

   Mobil mobil1 = new Mobil();
   Mobil mobil2 = new MobilSport();

   mobil1.berjalan(); // Output: Mobil berjalan
   mobil2.berjalan(); // Output: Mobil sport berjalan dengan cepat
   ```

5. **Abstraksi (Abstraction)**: Abstraksi adalah proses menyembunyikan detail implementasi dan hanya menampilkan fungsionalitas penting kepada pengguna. Ini dapat dicapai dengan menggunakan kelas abstrak dan antarmuka (interface).

   ```java
   public abstract class Kendaraan {
       abstract void berjalan();
   }

   public class Mobil extends Kendaraan {
       @Override
       void berjalan() {
           System.out.println("Mobil berjalan");
       }
   }
   ```

   ```java
   public interface Kendaraan {
       void berjalan();
   }

   public class Mobil implements Kendaraan {
       @Override
       public void berjalan() {
           System.out.println("Mobil berjalan");
       }
   }
   ```

Dengan memahami konsep-konsep OOP di Java, pengembang dapat menulis kode yang lebih terstruktur, mudah dipelihara, dan dapat digunakan kembali. Java OOP memungkinkan pengembang untuk membuat aplikasi yang kompleks dengan cara yang lebih terorganisir dan efisien.