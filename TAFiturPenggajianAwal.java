import java.util.Scanner;

public class TAFiturPenggajianAwal {
    public static void main(String[] args) {
        Scanner login = new Scanner(System.in);
        Scanner scsistem = new Scanner(System.in);
        Scanner scmenudata = new Scanner(System.in);
        Scanner scmenugaji = new Scanner(System.in);
        Scanner scidbuatgaji = new Scanner(System.in);

        int currentIndex = 3;

        String[][] user = {
                {"manager1", "password1"},
                {"manager2", "password2"}
        };
        String[][] dataKaryawan1 = new String[100][3];

        dataKaryawan1[0][0] = "BC01";
        dataKaryawan1[0][1] = "Manager";
        dataKaryawan1[0][2] = "Abhi";
        dataKaryawan1[1][0] = "BC02";
        dataKaryawan1[1][1] = "Staff Senior";
        dataKaryawan1[1][2] = "Jose";
        dataKaryawan1[2][0] = "BC03";
        dataKaryawan1[2][1] = "Staff Junior";
        dataKaryawan1[2][2] = "Eksa";

        double[][] gajiArray = {
                // Divisi: Backoffice
                {8000000, 0.05, 0.06},  // Manager
                {3000000, 0.04, 0.05},  // Staff Senior
                {2000000, 0.03, 0.04},  // Staff Junior

                // Divisi: Operasional
                {3500000, 0.05, 0.06},  // Head Kitchen
                {2500000, 0.04, 0.05},  // Crew Senior
                {1500000, 0.03, 0.04}   // Crew Junior
        };
        boolean isLoggedIn = false;
        int percobaanLogin = 0;
        int maxPercobaanLogin = 3;

        do {
            System.out.print("Username: ");
            String inputUsername = login.nextLine();
            System.out.print("Password: ");
            String inputPassword = login.nextLine();

            if ((inputUsername.equals(user[0][0]) || inputUsername.equals(user[1][0])) &&
                    (inputPassword.equals(user[0][1]) || inputPassword.equals(user[1][1]))) {
                System.out.println("Login berhasil!");
                isLoggedIn = true;
                break; // Keluar dari loop setelah login berhasil
            } else {
                System.out.println("Login gagal. Coba lagi.");
                percobaanLogin++;
            }
        } while (!isLoggedIn && percobaanLogin < maxPercobaanLogin);

        if (isLoggedIn) {
            while (true) {
                System.out.println("Selamat datang di Aplikasi Penggajian.");
                String[] sistem = {"Penggajian", "Data karyawan"};
                int inputSistem;

                System.out.println("|-----------------------------------|");
                System.out.println("|      Ingin masuk ke sistem apa?   |");
                System.out.println("|-----------------------------------|");
                System.out.println("|          1. Data karyawan         |");
                System.out.println("|          2. Penggajian            |");
                System.out.println("|-----------------------------------|");
                System.out.print("Masukkan sistem yang ingin anda masuki: ");
                inputSistem = scsistem.nextInt();

                if (inputSistem == 1) {
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
                        System.out.println("|============Data Karyawan===========|");
                        System.out.println("| ID  |      Jabatan      |   Nama   |");
                        System.out.println("|------------------------------------|");

                        for (int i = 0; i < currentIndex; i++) {
                            System.out.printf("| %-4s| %-18s| %-9s|%n", dataKaryawan1[i][0], dataKaryawan1[i][1], dataKaryawan1[i][2]);
                        }

                        System.out.println("|------------------------------------|");
                    } else if (inputmenudata == 2) {
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
                } else if (inputSistem == 2) {
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
                                
                                // Hitung gaji sesuai jabatan
                                double gajiDasar = gajiArray[i][0];
                                double tambahanGaji = gajiDasar * gajiArray[i][1];
                                double gajiLembur = gajiDasar * gajiArray[i][2];
                                double totalGaji = gajiDasar + tambahanGaji + gajiLembur;

                                // Tampilkan informasi gaji
                                System.out.println("Gaji Dasar   : " + gajiDasar);
                                System.out.println("Tambahan Gaji: " + tambahanGaji);
                                System.out.println("Gaji Lembur  : " + gajiLembur);
                                System.out.println("Total Gaji   : " + totalGaji);

                                break; // Keluar dari loop setelah menemukan kecocokan
                                        }
                                    }

                        if (!found) {
                            System.out.println("Karyawan dengan ID " + idkaryawan + " tidak ditemukan.");
                        }
                    }
                }
            }
        }
    }
}
