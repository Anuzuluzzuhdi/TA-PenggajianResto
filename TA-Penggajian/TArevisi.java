import java.util.Scanner;

public class TArevisi {

    static String[][] user = {
            {"manager1", "password1"},
            {"manager2", "password2"}
    };

    static String[][] dataKaryawan1;
    static double[][] gajiArray;
    static String[][] laporanGaji;

    static int currentIndex = 3;
    static int laporanCount = 0;

    static Scanner scsistem = new Scanner(System.in);
    static Scanner scmenudata = new Scanner(System.in);
    static Scanner scmenugaji = new Scanner(System.in);
    static Scanner scidbuatgaji = new Scanner(System.in);
    static Scanner scjamlembur = new Scanner(System.in);

    public static void main(String[] args) {
        dataKaryawan1 = new String[100][3];
        gajiArray = new double[][]{
                {8000000, 0.05, 0.06},  // Manager
                {3000000, 0.04, 0.05},  // Staff Senior
                {2000000, 0.03, 0.04}   // Staff Junior
        };
        laporanGaji = new String[100][9];

        // Inisialisasi data karyawan
        dataKaryawan1[0][0] = "BC01";
        dataKaryawan1[0][1] = "Manager";
        dataKaryawan1[0][2] = "Abhi";
        dataKaryawan1[1][0] = "BC02";
        dataKaryawan1[1][1] = "Staff Senior";
        dataKaryawan1[1][2] = "Jose";
        dataKaryawan1[2][0] = "BC03";
        dataKaryawan1[2][1] = "Staff Junior";
        dataKaryawan1[2][2] = "Eksa";

        boolean isLoggedIn = login();
        if (isLoggedIn) {
            menuUtama();
        }
    }

    static boolean login() {
        int percobaanLogin = 0;
        int maxPercobaanLogin = 3;

        do {
            System.out.print("Username: ");
            String inputUsername = scsistem.nextLine();
            System.out.print("Password: ");
            String inputPassword = scsistem.nextLine();

            if ((inputUsername.equals(user[0][0]) || inputUsername.equals(user[1][0])) &&
                    (inputPassword.equals(user[0][1]) || inputPassword.equals(user[1][1]))) {
                System.out.println("Login berhasil!");
                return true; // Keluar dari loop setelah login berhasil
            } else {
                System.out.println("Login gagal. Coba lagi.");
                percobaanLogin++;
            }
        } while (percobaanLogin < maxPercobaanLogin);

        System.out.println("Maaf, Anda telah melebihi batas percobaan login. Program berakhir.");
        return false;
    }

    static void menuUtama() {
        while (true) {
            System.out.println("Selamat datang di Aplikasi Penggajian.");
            String[] sistem = {"Penggajian", "Data karyawan", "Laporan Bulanan"};
            int inputSistem;

            System.out.println("|-----------------------------------|");
            System.out.println("|      Ingin masuk ke sistem apa?   |");
            System.out.println("|-----------------------------------|");
            System.out.println("|          1. Data karyawan         |");
            System.out.println("|          2. Penggajian            |");
            System.out.println("|          3. Laporan Bulanan       |");
            System.out.println("|-----------------------------------|");
            System.out.print("Masukkan sistem yang ingin anda masuki: ");
            inputSistem = scsistem.nextInt();

            switch (inputSistem) {
                case 1:
                    menuDataKaryawan();
                    break;
                case 2:
                    menuPenggajian();
                    break;
                case 3:
                    // Tambahkan logika untuk menu laporan bulanan di sini
                    break;
                default:
                    System.out.println("Input tidak valid. Silakan masukkan 1, 2, atau 3.");
                    break;
            }
        }
    }

    static void menuDataKaryawan() {
        do {
            int inputmenudata;
            String[] menudata = {"Data", "Tambah Data"};
            System.out.println("|-----------------------------------|");
            System.out.println("|        Sistem Data Karyawan       |");
            System.out.println("|-----------------------------------|");
            System.out.println("|       1. Data karyawan            |");
            System.out.println("|       2. Tambah Data karyawan     |");
            System.out.println("|       3. Kembali                  |");
            System.out.println("|-----------------------------------|");
            System.out.print("  Pilih menu yang ingin anda masuki:   ");
            inputmenudata = scmenudata.nextInt();

            if (inputmenudata == 1) {
                tampilkanDataKaryawan();
            } else if (inputmenudata == 2) {
                tambahDataKaryawan();
            } else if (inputmenudata == 3) {
                break;
            }
        } while (true);
    }

    static void tampilkanDataKaryawan() {
        System.out.println("|============Data Karyawan===========|");
        System.out.println("| ID  |      Jabatan      |   Nama   |");
        System.out.println("|------------------------------------|");

        for (int i = 0; i < currentIndex; i++) {
            System.out.printf("| %-4s| %-18s| %-9s|%n", dataKaryawan1[i][0], dataKaryawan1[i][1], dataKaryawan1[i][2]);
        }

        System.out.println("|------------------------------------|");
    }

    static void tambahDataKaryawan() {
        Scanner inputdata = new Scanner(System.in);
        int maxKaryawan = 15;
        boolean tambahData = true;

        while (tambahData && currentIndex < maxKaryawan) {
            System.out.println("Masukkan Nama Karyawan: ");
            String nama = inputdata.nextLine();
            System.out.println("Masukkan Jabatan Karyawan: ");
            String jabatan = inputdata.nextLine();
            System.out.println("Masukkan id: ");
            String id = inputdata.nextLine();

            dataKaryawan1[currentIndex][0] = id;
            dataKaryawan1[currentIndex][1] = jabatan;
            dataKaryawan1[currentIndex][2] = nama;
            currentIndex++;

            System.out.println("Data Karyawan yang Telah Ditambahkan:");
            System.out.println("Nama: " + nama);
            System.out.println("Jabatan: " + jabatan);
            System.out.println("ID: " + id);

            System.out.println("Tambah data karyawan lainnya? (ya/tidak): ");
            String jawaban = inputdata.nextLine();

            if (jawaban.equalsIgnoreCase("ya")) {
                System.out.println("Silakan masukkan data karyawan berikutnya");
            } else {
                System.out.println("Tidak ada data yang dimasukkan lagi. Terimakasih");
                tambahData = false;
            }
        }
    }

    static void menuPenggajian() {
        do {
            int inputmenugaji;
            String[] menugaji = {"Penggajian", "Kembali"};
            System.out.println("|-----------------------------------|");
            System.out.println("|     Sistem Penggajian Karyawan    |");
            System.out.println("|-----------------------------------|");
            System.out.println("|       1. Penggajian               |");
            System.out.println("|       2. Kembali                  |");
            System.out.println("|-----------------------------------|");
            System.out.print("  Pilih menu yang ingin anda masuki:   ");
            inputmenugaji = scmenugaji.nextInt();

            if (inputmenugaji == 1) {
                prosesPenggajian();
            } else if (inputmenugaji == 2) {
                break;
            }
        } while (true);
    }

    static void prosesPenggajian() {
        System.out.println("===========Penggajian Karyawan==========");
        System.out.println("Masukkan id karyawan yang ingin digaji: ");
        String idkaryawan = scidbuatgaji.nextLine();

        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            String[] karyawan = dataKaryawan1[i];
            if (karyawan[0].equals(idkaryawan)) {
                // Menampilkan informasi jika ID ditemukan
                System.out.println("| ID  |      Jabatan      |   Nama   |");
                System.out.println("|------------------------------------|");
                System.out.printf("| %-4s| %-18s| %-9s|%n", karyawan[0], karyawan[1], karyawan[2]);
                System.out.println("|------------------------------------|");
                found = true;

                System.out.println("Proses penggajian dilakukan di sini.");

                // Hitung gaji sesuai jabatan
                double gajiDasar = gajiArray[i][0];
                double pajak = gajiDasar * gajiArray[i][1];
                double tunjangan = gajiDasar * gajiArray[i][2];
                double gajiBersih = gajiDasar - pajak + tunjangan;
                laporanGaji[i][0] = karyawan[0];
                laporanGaji[i][1] = karyawan[1];
                laporanGaji[i][2] = karyawan[2];
                laporanGaji[i][3] = String.valueOf(gajiDasar);
                laporanGaji[i][4] = String.valueOf(pajak);
                laporanGaji[i][5] = String.valueOf(tunjangan);
                laporanGaji[i][6] = String.valueOf(gajiBersih);

                // Tampilkan informasi gaji
                System.out.println("|======Laporan Gaji======|");
                System.out.println("|Gaji Dasar   : " + gajiDasar + "|");
                System.out.println("|Pajak        : " + pajak + " |");
                System.out.println("|Tunjangan    : " + tunjangan + " |");
                System.out.println("|Total Gaji   : " + gajiBersih + "|");

                System.out.println("-----Inputan Lembur-----");
                System.out.print("|Masukkan Jam Lembur :|");
                int jmlembur = scjamlembur.nextInt();

                if (jmlembur > 0) {
                    int bonus = 20000;
                    double gajiLembur = jmlembur * bonus;
                    double totalGaji = gajiBersih + gajiLembur;
                    System.out.println("|  Gaji Lembur Anda = " + gajiLembur + "   |");
                    System.out.println("|  Total Gaji Anda  = " + totalGaji + " |");
                    laporanGaji[i][7] = String.valueOf(gajiLembur);
                    laporanGaji[i][8] = String.valueOf(totalGaji);
                } else {
                    System.out.println("|  Total Gaji Anda = " + gajiBersih + " |");
                }
                laporanCount++;
            }
        }

        if (!found) {
            System.out.println("Karyawan dengan ID " + idkaryawan + " tidak ditemukan.");
        }
    }
}
