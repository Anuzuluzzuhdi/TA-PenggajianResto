import java.util.Scanner;

public class arraypenggajian {
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
                String[] divisi = {"backoffice", "operasional"};
                String[] jabatan = {"manager", "staff", "head kitchen", "crew"};
                double[] gajipokok = {8000000, 3000000, 3500000, 2500000, 2000000, 1500000};
                double[] pajak = {0.05, 0.04, 0.03, 0.05, 0.04, 0.03};
                double[] tunjangan = {0.05, 0.04, 0.03, 0.05, 0.04, 0.03};

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
                String inputDivisi = input.nextLine();

                int divisiIndex = -1;
                for (int i = 0; i < divisi.length; i++) {
                    if (inputDivisi.equalsIgnoreCase(divisi[i])) {
                        divisiIndex = i;
                        break;
                    }
                }

                if (divisiIndex != -1) {
                    System.out.println("|-------------------------------|");
                    System.out.println("|                               |");
                    System.out.println("|      Jabatan Anda adalah ?    |");
                    System.out.println("|                               |");
                    System.out.println("|-------------------------------|");
                    System.out.println("|                               |");
                    for (int i = 0; i < jabatan.length; i++) {
                        System.out.println("|           " + jabatan[i] + "           |");
                    }
                    System.out.println("|                               |");
                    System.out.println("|-------------------------------|");
                    System.out.println("---Masukkan jabatan anda?---");
                    String inputJabatan = input.nextLine();

                    int jabatanIndex = -1;
                    for (int i = 0; i < jabatan.length; i++) {
                        if (inputJabatan.equalsIgnoreCase(jabatan[i])) {
                            jabatanIndex = i;
                            break;
                        }
                    }

                    if (jabatanIndex != -1) {
                        double nextgaji = gajipokok[jabatanIndex + (divisiIndex * jabatan.length)] -
                                (gajipokok[jabatanIndex + (divisiIndex * jabatan.length)] * pajak[jabatanIndex + (divisiIndex * jabatan.length)]) +
                                (gajipokok[jabatanIndex + (divisiIndex * jabatan.length)] * tunjangan[jabatanIndex + (divisiIndex * jabatan.length)]);

                        System.out.println("Gaji kotor anda adalah = " + nextgaji);

                        System.out.print("Masukkan Jam Lembur :");
                        int jamLembur = input.nextInt();

                        int gajiLembur;
                        int bonus = 20000;
                        double totalGaji;

                        if (jabatanIndex < 2 && jamLembur > 0) {
                            gajiLembur = jamLembur * bonus;
                            totalGaji = nextgaji + gajiLembur;
                            System.out.println("Gaji Lembur Anda =" + gajiLembur);
                            System.out.println("Total Gaji Anda =" + totalGaji);
                        } else {
                            System.out.println("Total Gaji Anda = " + nextgaji);
                        }
                    } else {
                        System.out.println("Jabatan yang anda masukan salah!");
                    }
                } else {
                    System.out.println("Divisi yang anda masukan salah!");
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
