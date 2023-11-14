import java.util.Scanner;

public class editTAFinal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] user = {
            {"manager1", "password1"},
            {"manager2", "password2"}
        };

        boolean isLoggedIn = false;
        int percobaanLogin = 0;
        int maxPercobaanLogin = 3;

        do {
            System.out.print("Username: ");
            String inputUsername = input.nextLine();
            System.out.print("Password: ");
            String inputPassword = input.nextLine();

            if ((inputUsername.equals(user[0][0]) || inputUsername.equals(user[1][0])) &&
                (inputPassword.equals(user[0][1]) || inputPassword.equals(user[1][1]))) {
                System.out.println("Login berhasil!");
                isLoggedIn = true;
            } else {
                System.out.println("Login gagal. Coba lagi.");
                percobaanLogin++;
            }
        } while (!isLoggedIn && percobaanLogin < maxPercobaanLogin);

        if (isLoggedIn) {
            System.out.println("Selamat datang di aplikasi kami.");

            String[] sistem = {"Penggajian", "Data karyawan"};
            int inputSistem;

            System.out.println("|-----------------------------------|");
            System.out.println("|      Ingin masuk ke sistem apa?   |");
            System.out.println("|-----------------------------------|");
            System.out.println("|          1. Penggajian            |");
            System.out.println("|          2. Data karyawan         |");
            System.out.println("|-----------------------------------|");
            System.out.print("Masukkan sistem yang ingin anda masuki: ");
            inputSistem = input.nextInt();
            input.nextLine(); // Membersihkan newline

            if (inputSistem >= 1 && inputSistem <= sistem.length) {
                if (inputSistem == 1) {
                    System.out.println("Anda masuk ke sistem " + sistem[inputSistem - 1] + ".");
                    //input.nextLine();

                    int maxSlipGaji = 100; // Misalnya, maksimal 100 slip gaji
                    String[] laporanSlipGaji = new String[maxSlipGaji];
                    int currentIndex = 0;

                    boolean sistemPeng = true;

                    while (sistemPeng) {
                        String[] divisi = {"Backoffice", "Operasional"};
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
                        int inputDivisi;
                        System.out.println("|-------------------------------|");
                        System.out.println("|         PILIH DIVISI:         |");
                        System.out.println("|-------------------------------|");
                        System.out.println("|         1. Backoffice         |");
                        System.out.println("|         2. Operasional        |");
                        System.out.println("|-------------------------------|");
                        System.out.print("Masukkan divisi anda? ");
                        inputDivisi = input.nextInt();
                        input.nextLine();

                        int divisiIndex = -1;

                        if (inputDivisi == 1) {
                            String[] jabatanBackoffice = {"Manager", "Staff Senior", "Staff Junior"};
                            int inputJabatan;
                            System.out.println("|-------------------------------|");
                            System.out.println("|         PILIH JABATAN:        |");
                            System.out.println("|-------------------------------|");
                            System.out.println("|         1. Manager            |");
                            System.out.println("|         2. Staff Senior       |");
                            System.out.println("|         3. Staff Junior       |");
                            System.out.println("|-------------------------------|");
                            System.out.print("---Masukkan jabatan anda? ");
                            inputJabatan = input.nextInt();
                            input.nextLine();

                            if (inputJabatan >= 1 && inputJabatan <= jabatanBackoffice.length) {
                                divisiIndex = inputJabatan - 1;
                            } else {
                                System.out.println("Jabatan yang anda masukkan tidak valid!");
                                continue;
                            }
                        } else if (inputDivisi == 2) {
                            String[] jabatanOperasional = {"Head Kitchen", "Crew Senior", "Crew Junior"};
                            int inputJabatan;
                            System.out.println("|-------------------------------|");
                            System.out.println("|        PILIH JABATAN:         |");
                            System.out.println("|-------------------------------|");
                            System.out.println("|        1. Head Kitchen        |");
                            System.out.println("|        2. Crew Senior         |");
                            System.out.println("|        3. Crew Junior         |");
                            System.out.println("|-------------------------------|");
                            System.out.print("---Masukkan jabatan anda? ");
                            inputJabatan = input.nextInt();
                            input.nextLine();

                            if (inputJabatan >= 1 && inputJabatan <= jabatanOperasional.length) {
                                divisiIndex = 2 + inputJabatan; // Menyesuaikan indeks untuk operasional
                            } else {
                                System.out.println("Jabatan yang anda masukkan tidak valid!");
                                continue;
                            }
                        }

                        if (divisiIndex >= 0) {
                            double gajipokok = gajiArray[divisiIndex][0];
                            double pajak = gajiArray[divisiIndex][1];
                            double tunjangan = gajiArray[divisiIndex][2];

                            System.out.println("Gaji kotor anda adalah = " + (gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan)));

                            System.out.print("Masukkan Jam Lembur :");
                            int jamLembur = input.nextInt();

                            if (jamLembur > 0) {
                                int bonus = 20000;
                                double gajiLembur = jamLembur * bonus;
                                double totalGaji = (gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan)) + gajiLembur;
                                System.out.println("Gaji Lembur Anda = " + gajiLembur);
                                System.out.println("Total Gaji Anda = " + totalGaji);
                            } else {
                                System.out.println("Total Gaji Anda = " + (gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan)));
                            }
                        } else {
                            System.out.println("Kategori yang anda masukkan salah!");
                        }

                        System.out.print("Ingin menghitung gaji dengan jabatan lainnya? (ya/tidak): ");
                        String jawaban = input.next();
                        input.nextLine();
                        if (jawaban.equalsIgnoreCase("ya")) {
                            continue;
                        } else {
                            sistemPeng = false;
                        }
                    }

                    //System.out.print("Ingin mencetak seluruh slip gaji? (ya/tidak): ");
                    //String cetakSemua = input.next();
                    //input.nextLine();

                    //if (cetakSemua.equalsIgnoreCase("ya")) {
                        //System.out.println("Melakukan pencetakan seluruh slip gaji...");
                        //for (int i = 0; i < currentIndex; i++) {
                            //double gajipokok = 0;  
                            //double pajak = 0; 
                            //double tunjangan = 0;  
                    
                            // Gantilah nilai gajipokok, pajak, dan tunjangan sesuai dengan data karyawan
                            // ...
                    
                            //double gajiKotor = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    
                            //System.out.println("Slip Gaji " + (i + 1) + ":");
                            //System.out.println("Nama: " + dataKaryawan[i][0]);
                            //System.out.println("Jabatan: " + dataKaryawan[i][1]);
                            //System.out.println("Masa Kerja: " + dataKaryawan[i][2] + " tahun");
                            //System.out.println("Gaji Bersih: " + to);
                            //System.out.println();  // Baris kosong sebagai pemisah antar slip gaji
                        //}
                    
                        //System.out.println("Seluruh slip gaji telah dicetak.");
                    //}
                } else if (inputSistem == 2) {
                    int currentIndex = 0;
                int maxKaryawan = 15;
                String[][] dataKaryawan = new String[maxKaryawan][3]; // {nama, jabatan, masaKerja}

                boolean tambahData = true;

                while (tambahData && currentIndex < maxKaryawan) {
                    System.out.println("Masukkan Nama Karyawan: ");
                    String nama = input.nextLine();
                    System.out.println("Masukkan Jabatan Karyawan: ");
                    String jabatan = input.nextLine();
                    System.out.println("Masukkan Masa Kerja (dalam tahun): ");
                    String masaKerja = input.nextLine();

                    dataKaryawan[currentIndex][0] = nama;
                    dataKaryawan[currentIndex][1] = jabatan;
                    dataKaryawan[currentIndex][2] = masaKerja;
                    currentIndex++;

                    System.out.println("Data Karyawan yang Telah Ditambahkan:");
                    System.out.println("Nama: " + nama);
                    System.out.println("Jabatan: " + jabatan);
                    System.out.println("Masa Kerja: " + masaKerja + " tahun");

                    System.out.println("Tambah data karyawan lainnya? (ya/tidak/cetak): ");
                    String jawaban = input.nextLine();

                    if (jawaban.equalsIgnoreCase("ya")) {
                        System.out.println("Silakan masukkan data karyawan berikutnya");
                    } else if (jawaban.equalsIgnoreCase("cetak")) {
                        for (int i = 0; i < currentIndex; i++) {
                            System.out.println("Index: " + i);
                            System.out.println("Nama: " + dataKaryawan[i][0]);
                            System.out.println("Jabatan: " + dataKaryawan[i][1]);
                            System.out.println("Masa Kerja: " + dataKaryawan[i][2]);
                            tambahData = false;
                        }
                    } else {
                        System.out.println("Tidak ada data yang dimasukkan lagi. Terimakasih");
                        tambahData = false;
                    }
                }
                } else {
                    System.out.println("Sistem tidak valid");
                }
            } else {
                System.out.println("Anda telah mencoba login sebanyak " + maxPercobaanLogin + " kali. Aplikasi ditutup.");
                isLoggedIn = false;
            }
        }
    }
}
