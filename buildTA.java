import java.util.Scanner;

public class buildTA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] usernames = {"manager1", "manager2"};
        String[] passwords = {"password1", "password2"};
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.print("Username: ");
            String inputUsername = input.nextLine();
            System.out.print("Password: ");
            String inputPassword = input.nextLine();

            for (int i = 0; i < usernames.length; i++) {
                if (inputUsername.equals(usernames[i]) && inputPassword.equals(passwords[i])) {
                    System.out.println("Login berhasil!");
                    isLoggedIn = true;
                    break;
                }
            }

            if (!isLoggedIn) {
                System.out.println("Login gagal. Coba lagi.");
            }
        }

        if (isLoggedIn) {
            System.out.println("=======Selamat datang di aplikasi kami=======");

            String sistem;

            System.out.println("|-----------------------------------|");
            System.out.println("|                                   |");
            System.out.println("|      Ingin masuk ke sistem apa?   |");
            System.out.println("|                                   |");
            System.out.println("|-----------------------------------|");
            System.out.println("|                                   |");
            System.out.println("|          Penggajian               |");
            System.out.println("|          Data karyawan            |");
            System.out.println("|                                   |");
            System.out.println("|-----------------------------------|");
            System.out.println("Masukkan sistem yang ingin anda masuki");
            sistem = input.nextLine();

            if (sistem.equalsIgnoreCase("Penggajian")) {
                String divisi, jabatan;
                double[][] gajiArray = {
                    // Divisi: Backoffice
                    {8000000, 0.05, 0.05},  // Manager
                    {3000000, 0.04, 0.04},  // Staff Senior
                    {2000000, 0.03, 0.03},  // Staff Junior

                    // Divisi: Operasional
                    {3500000, 0.05, 0.05},  // Head Kitchen
                    {2500000, 0.04, 0.04},  // Crew Senior
                    {1500000, 0.03, 0.03}   // Crew Junior
                };

                System.out.println("|-------------------------------|");
                System.out.println("|                               |");
                System.out.println("|      Kategori Anda adalah ?   |");
                System.out.println("|                               |");
                System.out.println("|-------------------------------|");
                System.out.println("|                               |");
                System.out.println("|          Backoffice           |");
                System.out.println("|          Operasional          |");
                System.out.println("|                               |");
                System.out.println("|-------------------------------|");
                System.out.println("Masukkan divisi anda?");
                divisi = input.nextLine();

                int divisiIndex = -1;

                if (divisi.equalsIgnoreCase("backoffice")) {
                    System.out.println("|-------------------------------|");
                    System.out.println("|                               |");
                    System.out.println("|      Jabatan Anda adalah ?    |");
                    System.out.println("|                               |");
                    System.out.println("|-------------------------------|");
                    System.out.println("|                               |");
                    System.out.println("|           Manager             |");
                    System.out.println("|           Staff               |");
                    System.out.println("|                               |");
                    System.out.println("|-------------------------------|");
                    System.out.println("---Masukkan jabatan anda?---");
                    jabatan = input.nextLine();

                    if (jabatan.equalsIgnoreCase("manager")) {
                        divisiIndex = 0;
                    } else if (jabatan.equalsIgnoreCase("staff")) {
                        System.out.println("-----Apakah anda senior atau junior?-----");
                        System.out.println("senior/junior");
                        jabatan = input.nextLine();
                        if (jabatan.equalsIgnoreCase("senior")) {
                            divisiIndex = 1;
                        } else if (jabatan.equalsIgnoreCase("junior")) {
                            divisiIndex = 2;
                        }
                    }
                } else if (divisi.equalsIgnoreCase("operasional")) {
                    System.out.println("|-------------------------------|");
                    System.out.println("|                               |");
                    System.out.println("|      Jabatan Anda adalah ?    |");
                    System.out.println("|                               |");
                    System.out.println("|-------------------------------|");
                    System.out.println("|                               |");
                    System.out.println("|          Head Kitchen         |");
                    System.out.println("|          Crew                 |");
                    System.out.println("|                               |");
                    System.out.println("|-------------------------------|");
                    System.out.println("---Masukkan jabatan anda?---");
                    jabatan = input.nextLine();

                    if (jabatan.equalsIgnoreCase("head kitchen")) {
                        divisiIndex = 3;
                    } else if (jabatan.equalsIgnoreCase("crew")) {
                        System.out.println("-----Apakah anda senior atau junior?-----");
                        System.out.println("senior/junior");
                        jabatan = input.nextLine();
                        if (jabatan.equalsIgnoreCase("senior")) {
                            divisiIndex = 4;
                        } else if (jabatan.equalsIgnoreCase("junior")) {
                            divisiIndex = 5;
                        }
                    }
                }

                if (divisiIndex >= 0) {
                    double gajipokok = gajiArray[divisiIndex][0];
                    double pajak = gajiArray[divisiIndex][1];
                    double tunjangan = gajiArray[divisiIndex][2];

                    System.out.println(("Gaji kotor anda adalah = " + (gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan))));

                    System.out.print("Masukkan Jam Lembur :");
                    int jamLembur = input.nextInt();

                    if (jamLembur > 0) {
                        int bonus = 20000;
                        double gajiLembur = jamLembur * bonus;
                        double totalGaji = (gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan)) + gajiLembur;
                        System.out.println("Gaji Lembur Anda =" + gajiLembur);
                        System.out.println("Total Gaji Anda =" + totalGaji);
                    } else {
                        System.out.println("Total Gaji Anda = " + (gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan)));
                    }
                } else {
                    System.out.println("Kategori yang anda masukan salah!");
                }
            } else if (sistem.equalsIgnoreCase("Data karyawan")) {
                String[] namaKaryawan = new String[100];
                String[] jabatanKaryawan = new String[100];
                int[] masaKerjaKaryawan = new int[100];
                boolean tambahData = true;
                int karyawanCount = 0;

                while (tambahData) {
                    System.out.println("Masukkan Nama Karyawan: ");
                    namaKaryawan[karyawanCount] = input.nextLine();
                    System.out.println("Masukkan Jabatan Karyawan: ");
                    jabatanKaryawan[karyawanCount] = input.nextLine();
                    System.out.println("Masukkan Masa Kerja (dalam tahun): ");
                    masaKerjaKaryawan[karyawanCount] = input.nextInt();
                    input.nextLine(); // iki lho kudu nggawe iki, lek ga error

                    System.out.println("Data Karyawan yang Telah Ditambahkan:");
                    System.out.println("Nama: " + namaKaryawan[karyawanCount]);
                    System.out.println("Jabatan: " + jabatanKaryawan[karyawanCount]);
                    System.out.println("Masa Kerja: " + masaKerjaKaryawan[karyawanCount] + " tahun");

                    karyawanCount++;

                    System.out.println("Tambah data karyawan lainnya? (ya/tidak): ");
                    String jawaban = input.nextLine();

                    if (jawaban.equalsIgnoreCase("ya")) {
                        System.out.println("Silakan masukkan data karyawan berikutnya");
                    } else {
                        System.out.println("Tidak ada data yang dimasukkan lagi. Terimakasih");
                        tambahData = false;
                    }
                }
            } else {
                System.out.println("Sistem tidak valid");
            }
        }
    }
}
