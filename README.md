# Data Mahasiswa Application

Proyek ini adalah aplikasi Android yang memungkinkan pengguna untuk melakukan operasi CRUD (Create, Read, Update, Delete) pada data mahasiswa. Aplikasi ini menggunakan Clean arsitektur Pattern dan MVVM. Aplikasi ini didukung oleh beberapa teknologi modern seperti Room, ViewModel, Flow, dan Koin untuk dependency injection.

## Fitur

- Tambah data mahasiswa
- Lihat daftar mahasiswa
- Edit data mahasiswa
- Hapus data mahasiswa

## Teknologi yang Digunakan

- **Kotlin**: Bahasa pemrograman utama untuk pengembangan aplikasi Android ini.
- **Android Jetpack**:
  - **Room**: Untuk penyimpanan data lokal.
  - **ViewModel**: Untuk mengelola dan menyimpan data UI.
  - **Fragment**: Untuk Menampung UI dan ditampilkan ke layar.
- **Flow**: Untuk observer data yang hidup.
- **Koin**: Dependency Injection untuk mengelola dependensi.
- **Navigation Component**: Untuk navigasi antar fragment.
- **Material Design**: Untuk UI yang modern dan responsif.

## Persyaratan Sistem

- Android Studio Bumblebee atau versi yang lebih baru
- Gradle 8.4.0 atau yang lebih baru
- Minimum SDK 21
- JDK 8 atau yang lebih baru

## Cara Menjalankan Proyek

1. **Clone repository ini**:

    ```sh
    git clone https://github.com/miftahulacil0608/Data-Mahasiswa-Apps.git
    ```

2. **Buka proyek dengan Android Studio**:

    - Buka Android Studio.
    - Pilih `Open an existing Android Studio project`.
    - Arahkan ke direktori tempat Anda meng-clone repository ini dan klik `OK`.

3. **Sync proyek dengan Gradle**:

    - Tunggu hingga Android Studio selesai mensinkronisasi proyek dengan Gradle.

4. **Jalankan aplikasi**:

    - Sambungkan perangkat Android Anda atau gunakan emulator Android.
    - Klik tombol `Run` (ikon hijau segitiga) di toolbar atau tekan `Shift + F10`.

## Contoh/Demo Penggunaan

Berikut adalah beberapa langkah untuk menggunakan aplikasi:

1. **Tambah Data Mahasiswa**:

    - Buka aplikasi.
    - Klik tombol `Tambah Mahasiswa`.
    - Isi formulir dengan data mahasiswa (Nama, NIM, Fakultas, Jurusan, Alamat).
    - Klik tombol `Submit`.
    - Data mahasiswa baru akan ditambahkan ke dalam daftar.

2. **Lihat Daftar Mahasiswa**:

    - Pada layar utama, Anda akan melihat daftar semua mahasiswa yang telah ditambahkan.
    - Setiap item dalam daftar menampilkan informasi dasar tentang mahasiswa.

3. **Edit Data Mahasiswa**:

    - Klik pada mahasiswa yang ingin Anda edit di daftar.
    - Pada layar detail, klik tombol `Edit`.
    - Ubah data yang diperlukan di formulir edit.
    - Klik tombol `Submit` untuk menyimpan perubahan.

4. **Hapus Data Mahasiswa**:

    - Klik pada mahasiswa yang ingin Anda hapus di daftar.
    - Pada layar detail, klik tombol `Hapus`.
    - Konfirmasi tindakan penghapusan.
    - Data mahasiswa akan dihapus dari daftar.

## Struktur Proyek

- **ui**: Berisi semua fragment, aktivitas yang mengelola tampilan UI, dan ViewModel yang digunakan untuk mengelola data UI.
- - **domain**: Berisi logika bisnis dan use case.
- **data**: Berisi model data dan repository untuk mengakses database.
- **common**: Berisi utilitas, konstanta, dan kelas-kelas yang dapat digunakan secara umum di seluruh aplikasi.
- **di**: Berisi konfigurasi Koin untuk dependency injection.

## Kontribusi

Jika Anda ingin berkontribusi pada proyek ini, silakan fork repository ini, buat branch untuk perubahan Anda, dan kirim pull request. Saya sangat menghargai kontribusi Anda!
