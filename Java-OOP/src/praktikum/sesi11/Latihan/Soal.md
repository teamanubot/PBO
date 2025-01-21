## Deskripsi Soal

Buatlah program Java untuk manajemen kendaraan dengan fitur-fitur berikut :

### 1. **Abstract Class :**

Gunakan abstract class `Kendaraan` yang memiliki atribut dan method dasar untuk semua kendaraan.

### 2. **Interface :**

Buat tiga interface yang harus diimplementasikan oleh kendaraan tertentu :

- `Mesin` : Interface yang mengatur fungsi mesin kendaraan.
- `Penumpang` : Interface yang mengatur manajemen penumpang.
- `FiturTambahan` : Interface untuk kendaraan dengan fitur tambahan.

### 3. **Final Class :**

- `CetakKendaraan` adalah final class yang digunakan untuk mencetak detail dari semua jenis kendaraan.

### 4. **Polimorfisme :**

Tampilkan kemampuan kendaraan melalui polimorfisme menggunakan abstract class dan interface. Semua kendaraan harus dapat dikelola dalam satu array dan diproses menggunakan loop.

### 5. **Jenis Kendaraan :**

Buatlah tiga jenis kendaraan sebagai subclass dari `Kendaraan` yang mengimplementasikan method sesuai kebutuhan :

- `Mobil`
- `Motor`
- `Bus`

### 6. **Fitur-fitur Program:**

- **Fungsi Mesin :**
  Semua kendaraan dapat dihidupkan dan dimatikan mesinnya. Pastikan setiap kendaraan mengimplementasikan method untuk menghidupkan dan mematikan mesin.
- **Manajemen Penumpang :**
  Atur jumlah penumpang maksimum untuk kendaraan. Pastikan kendaraan memiliki cara untuk mengatur jumlah penumpang yang dapat diakomodasi.
- **Fitur Tambahan :**
  Beberapa kendaraan memiliki fitur tambahan seperti AC, WiFi, atau GPS. Pastikan fitur ini diimplementasikan hanya pada kendaraan yang relevan.
- **Polimorfisme :**
  Semua kendaraan harus dapat dikelola dalam satu array dan diproses dengan menggunakan loop. Anda bisa menggunakan array untuk menyimpan objek kendaraan dan melakukan operasi pada objek-objek tersebut.
