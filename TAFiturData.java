// TA AFTER EVAL WITH BU VIVIN
// PENGERJAAN SISTEM DATA KARYAWAN
import java.util.Scanner;
public class TAFiturData {
    public static void main(String[] args) {
        Scanner login = new Scanner(System.in);
        Scanner scsistem = new Scanner(System.in);
        Scanner scmenudata = new Scanner(System.in);
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
            } else {
                System.out.println("Login gagal. Coba lagi.");
                percobaanLogin++;
            }
        } while (!isLoggedIn && percobaanLogin < maxPercobaanLogin);

        if (isLoggedIn) {
        do{
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
            scsistem.nextLine(); // Membersihkan newline

            if (inputSistem >= 1 && inputSistem <= sistem.length) {
                if (inputSistem == 1){

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
                    scmenudata.nextLine();

                     if (inputmenudata == 1) {
                    

                    System.out.println("|============Data Karyawan===========|");
                    System.out.println("| ID  |      Jabatan      |   Nama   |");
                    System.out.println("|------------------------------------|");
                    
                    for (int i=0; i<currentIndex;i++) {
                        System.out.printf("| %-4s| %-18s| %-9s|%n", dataKaryawan1[i][0], dataKaryawan1[i][1], dataKaryawan1[i][2]);
                    }
                

                    System.out.println("|------------------------------------|");
                } else if (inputmenudata == 2) {
                    Scanner inputdata = new Scanner(System.in);
                    int maxKaryawan = 15;
                    boolean tambahData = true;
                    //String[][] dataKaryawan1 = new String[maxKaryawan][3];

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
                        System.out.println("Masa Kerja: " + id + " tahun");

                        System.out.println("Tambah data karyawan lainnya? (ya/tidak): ");
                        String jawaban = inputdata.nextLine();

                        if (jawaban.equalsIgnoreCase("ya")) {
                            System.out.println("Silakan masukkan data karyawan berikutnya");
                        } 
                            
                         else {
                            System.out.println("Tidak ada data yang dimasukkan lagi. Terimakasih");
                            tambahData = false;
                        }
                    }
                } else if (inputmenudata == 3) {
                   
                }
            }
        }
    } while(true);
    }
}
}