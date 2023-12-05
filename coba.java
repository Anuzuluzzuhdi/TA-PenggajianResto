import java.util.Scanner;

public class coba {

    static double [][]gajiArray;
    static String [][]dataKaryawan1;
    static String [][]laporanGaji;

    static int currentIndex = 3;
    static int laporanCount = 0;

    public static void menuPenggajian() {
        do {
            Scanner scmenugaji = new Scanner(System.in);
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
        Scanner scjamlembur = new Scanner(System.in);
        Scanner scidbuatgaji = new Scanner(System.in);
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

    public static void main(String[] args) {
        dataKaryawan1 = new String[100][3];
        gajiArray = new double[][]{
            {8000000, 0.05, 0.06},  // Manager
            {3000000, 0.04, 0.05},  // Staff Senior
            {2000000, 0.03, 0.04}   // Staff Junior
    };
        laporanGaji = new String[100][9];

        dataKaryawan1[0][0] = "BC01";
        dataKaryawan1[0][1] = "Manager";
        dataKaryawan1[0][2] = "Abhi";
        dataKaryawan1[1][0] = "BC02";
        dataKaryawan1[1][1] = "Staff Senior";
        dataKaryawan1[1][2] = "Jose";
        dataKaryawan1[2][0] = "BC03";
        dataKaryawan1[2][1] = "Staff Junior";
        dataKaryawan1[2][2] = "Eksa";
    }
}