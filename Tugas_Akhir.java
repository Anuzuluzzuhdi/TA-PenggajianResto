import java.util.Scanner;
public class Tugas_Akhir {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    
        
    String[][] user = {
        {"manager1", "password1"},
        {"manager2", "password2"}
    };
    
    boolean isLoggedIn = false;
    int loginAttempts = 0;
    int maxLoginAttempts = 3;

    do {
        System.out.print("Username: ");
        String inputUsername = input.nextLine();
        System.out.print("Password: ");
        String inputPassword = input.nextLine();

        if ((inputUsername.equals(user[0][0]) || inputUsername.equals(user[1][0])) && (inputPassword.equals(user[0][1]) || inputPassword.equals(user[1][1]))) {
            System.out.println("Login berhasil!");
            isLoggedIn = true;
        } else {
            System.out.println("Login gagal. Coba lagi.");
            loginAttempts++;
        }
    } while (!isLoggedIn && loginAttempts < maxLoginAttempts);

    if (isLoggedIn) {
        System.out.println("Selamat datang di aplikasi kami.");
    

    String[] sistem = {"Penggajian", "Data karyawan"};
    String inputSistem;

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
        inputSistem = input.nextLine();

    if (inputSistem.equalsIgnoreCase(sistem[0])) {
        
        int maxSlipGaji = 100;  // Misalnya, maksimal 100 slip gaji
        String[] laporanSlipGaji = new String[maxSlipGaji];
        int currentIndex = 0;
        
        boolean sistemPeng = true;

    while (sistemPeng) {
        //String[] divisi = {"Backoffice", "Operasional"};
        String divisi, jabatan, senior, jawaban;
        int gajipokok;
        double pajak, tunjangan, nextgaji;

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

        if (divisi.equalsIgnoreCase("backoffice"))
        {
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

            if (jabatan.equalsIgnoreCase("manager"))
            {
                gajipokok =+ 8000000;
                pajak =+ 0.05;
                tunjangan = 0.05;

                nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                System.out.println("Gaji kotor anda adalah = " +nextgaji);

                System.out.print("Masukkan Jam Lembur :");
                    int jamLembur = input.nextInt();

                
                    int gajiLembur;
                    int bonus=20000;
                    double totalGaji;

                    if (jamLembur>0){
                     gajiLembur = jamLembur * bonus;
                    totalGaji = nextgaji + gajiLembur;

                    System.out.println("===SLIP GAJI===");
                    System.out.println("Gaji Lembur Anda =" +gajiLembur);
                    System.out.println("Total Gaji Anda =" +totalGaji);
                    } else {
                    System.out.println("Total Gaji Anda = " +nextgaji);
                    }
            

            }
            else if (jabatan.equalsIgnoreCase("staff"))
            {
                System.out.println("-----Apakah anda senior?----- ");
                System.out.println("senior/junior");
                
                jabatan = input.nextLine();
                if (jabatan.equalsIgnoreCase("Senior"))
                {
                    gajipokok =+ 3000000;
                    pajak =+ 0.04;
                    tunjangan = 0.04;

                    nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    System.out.println("Gaji kotor anda adalah = " +nextgaji);
                    
                    System.out.print("Masukkan Jam Lembur :");
                    int jamLembur = input.nextInt();

                
                    int gajiLembur;
                    int bonus=20000;
                    double totalGaji;

                    if (jamLembur>0){
                     gajiLembur = jamLembur * bonus;
                    totalGaji = nextgaji + gajiLembur;
                    System.out.println("Gaji Lembur Anda =" +gajiLembur);
                    System.out.println("Total Gaji Anda =" +totalGaji);
                    } else {
                    System.out.println("Total Gaji Anda = " +nextgaji);
                    }
                }
                else if (jabatan.equalsIgnoreCase("Junior"))
                {
                    gajipokok =+ 2000000;
                    pajak =+ 0.03;
                    tunjangan = 0.03;

                    nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    System.out.println("Gaji anda adalah = " +nextgaji);
                }                

            }
        }
        else if (divisi.equalsIgnoreCase("operasional"))
        {

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
            if (jabatan.equalsIgnoreCase("head kitchen"))
            {
                gajipokok =+ 3500000;
                pajak =+ 0.05;
                tunjangan = 0.05;

                nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                System.out.println("Gaji kotor anda adalah = " +nextgaji);

                System.out.print("Masukkan Jam Lembur :");
                    int jamLembur = input.nextInt();

                
                    int gajiLembur;
                    int bonus=20000;
                    double totalGaji;

                    if (jamLembur>0){
                     gajiLembur = jamLembur * bonus;
                    totalGaji = nextgaji + gajiLembur;
                    System.out.println("Gaji Lembur Anda =" +gajiLembur);
                    System.out.println("Total Gaji Anda =" +totalGaji);
                    } else {
                    System.out.println("Total Gaji Anda = " +nextgaji);
                    }
            }
            else if (jabatan.equalsIgnoreCase("crew"))
            {
                System.out.println("-----Apakah anda senior?-----");
                System.out.println("Senior/junior");
                
                jabatan = input.nextLine();
                if (jabatan.equalsIgnoreCase("Senior"))
                {
                    gajipokok =+ 2500000;
                    pajak =+ 0.04;
                    tunjangan = 0.04;

                    nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    System.out.println("Gaji kotor anda adalah = " +nextgaji);
                    
                    System.out.print("Masukkan Jam Lembur :");
                    int jamLembur = input.nextInt();

                
                    int gajiLembur;
                    int bonus=20000;
                    double totalGaji;

                    if (jamLembur>0){
                     gajiLembur = jamLembur * bonus;
                    totalGaji = nextgaji + gajiLembur;
                    System.out.println("Gaji Lembur Anda =" +gajiLembur);
                    System.out.println("Total Gaji Anda =" +totalGaji);
                    } else {
                    System.out.println("Total Gaji Anda = " +nextgaji);
                    }
                }
                else if (jabatan.equalsIgnoreCase("Junior"))
                {
                    gajipokok =+ 1500000;
                    pajak =+ 0.03;
                    tunjangan = 0.03;

                    nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    System.out.println("Gaji Bersih Anda Adalah = " +nextgaji);

                    System.out.print("Masukkan Jam Lembur :");
                    int jamLembur = input.nextInt();

                
                    int gajiLembur;
                    int bonus=20000;
                    double totalGaji;

                    if (jamLembur>0){
                     gajiLembur = jamLembur * bonus;
                    totalGaji = nextgaji + gajiLembur;
                    System.out.println("Gaji Lembur Anda =" +gajiLembur);
                    System.out.println("Total Gaji Anda =" +totalGaji);
                    } else {
                    System.out.println("Total Gaji Anda = " +nextgaji);
                    }
                }                 
            }

        }
        else 
        {
            System.out.println("Kategori yang anda masukan salah!");
        }

        System.out.print("Ingin menghitung gaji dengan jabatan lainnya? (ya/tidak): ");
        jawaban = input.nextLine();
        if (jawaban.equalsIgnoreCase("ya")) {
            continue;
        } else {
            sistemPeng = false;
        }

    
    }
    } else if (inputSistem.equalsIgnoreCase(sistem[1])) {
        
        int currentIndex = 0;
        int maxEmployees = 15;
        String[][] employeeInfo = new String[maxEmployees][3]; // {nama, jabatan, masaKerja}
        
        boolean tambahData = true;

        while (tambahData && currentIndex < maxEmployees) {
            for (int i = 0; i < 3; i++) {
                String dataLabel = i == 0 ? "Nama" : (i == 1 ? "Jabatan" : "Masa Kerja (dalam tahun)");
                System.out.print("Masukkan " + dataLabel + " Karyawan: ");
                String inputData = input.nextLine();
                employeeInfo[currentIndex][i] = inputData;
            }
            currentIndex++;
            
            System.out.println("Data Karyawan yang Telah Ditambahkan:");
            System.out.println("Nama: " + employeeInfo[currentIndex - 1][0]);
            System.out.println("Jabatan: " + employeeInfo[currentIndex - 1][1]);
            System.out.println("Masa Kerja: " + employeeInfo[currentIndex - 1][2] + " tahun");

            System.out.println("Tambah data karyawan lainnya? (ya/tidak/cek): ");
            String jawaban = input.nextLine();

            if (jawaban.equalsIgnoreCase("ya")) {
                System.out.println("Silakan masukkan data karyawan berikutnya");
            } else if (jawaban.equalsIgnoreCase("cek")) {
                for (int i = 0; i < currentIndex; i++) {
                    System.out.println("Index: " + i);
                    System.out.println("Nama: " + employeeInfo[i][0]);
                    System.out.println("Jabatan: " + employeeInfo[i][1]);
                    System.out.println("Masa Kerja: " + employeeInfo[i][2]);
                }
                tambahData = false;
            } else {
                System.out.println("Tidak ada data yang dimasukkan lagi. Terimakasih");
                tambahData = false;
            }
            }

    } else {
        System.out.println("Sistem tidak valid");
    }
}     else {
        System.out.println("Anda telah mencoba login sebanyak " + maxLoginAttempts + " kali. Aplikasi ditutup.");
        isLoggedIn = false;
    }
    
}
}