//untuk import scanner nya
import java.util.Scanner;

public class TAlagi {

    //fungsi untuk login 
    static String[][] user = {
            {"manager1", "password1"},
            {"manager2", "password2"}
    };
    //fungsi untuk masuk ketika login
    static String loggedInManager;

    //deklarasi array untuk data karyawan
    static String[][] dataKaryawan1;
    static String[][] dataKaryawan2;
    // Variabel untuk menyimpan indeks gaji sesuai jabatan
    static int indeksGaji;

    //deklarasi array untuk gaji karyawan
    static double[][] gajiBackoffice;
    static double[][] gajiOperasional;
    static int indeksGajiPenggajian;

    //deklarasi array untuk laporan bulanan penggajian
    static String[][] laporanGaji;
    //setting indeks awal untuk nanti di sistem data
    //dan juga di sistem penggajian karena data awal ada 3
    static int currentIndex = 3;
    //inisialisasi dimulai dari 0 karena belum ada laporan
    //nanti akan diincrement setiap laporan dibuat
    static int laporanCount = 0;
    //deklarasi scanner untuk tiap-tiapnya
    static Scanner scsistem = new Scanner(System.in);
    static Scanner scmenudata = new Scanner(System.in);
    static Scanner inputdata = new Scanner(System.in);
    static Scanner scmenugaji = new Scanner(System.in);
    static Scanner scidbuatgaji = new Scanner(System.in);
    static Scanner scjamlembur = new Scanner(System.in);
    //fungsi main yang dimana ada deklarasi dan inisialisasi 
    //data karyawan beserta gajinya 
    //lalu memanggil fungsi login yang didalamnya nanti akan 
    //memanggil fungsi menu utama
    public static void main(String[] args) {
        dataKaryawan1 = new String[100][3];
        dataKaryawan2 = new String[100][3];
        //deklarasi dan inisialisasi array gaji untuk backoffice
        
        gajiBackoffice = new double[][]{
                {8000000, 0.05, 0.06},  // Manager
                {3000000, 0.04, 0.05},  // Staff Senior
                {2000000, 0.03, 0.04}   // Staff Junior
        };
        //deklarasi dan inisialisasi array gaji untuk operasional
         gajiOperasional = new double[][]{
                {8000000, 0.05, 0.06},  // Head Kitchen
                {3000000, 0.04, 0.05},  // Crew Senior
                {2000000, 0.03, 0.04}   // Crew Junior
        };

        laporanGaji = new String[100][9];

        // Inisialisasi data karyawan backoffice
        dataKaryawan1[0][0] = "BC01";
        dataKaryawan1[0][1] = "Manager";
        dataKaryawan1[0][2] = "Abhi";
        dataKaryawan1[1][0] = "BC02";
        dataKaryawan1[1][1] = "Staff Senior";
        dataKaryawan1[1][2] = "Jose";
        dataKaryawan1[2][0] = "BC03";
        dataKaryawan1[2][1] = "Staff Junior";
        dataKaryawan1[2][2] = "Eksa";

        //inisialisasi data karyawan operasional
        dataKaryawan2[0][0] = "OP01";
        dataKaryawan2[0][1] = "Head Kitchen";
        dataKaryawan2[0][2] = "Naya";
        dataKaryawan2[1][0] = "OP02";
        dataKaryawan2[1][1] = "Crew Senior";
        dataKaryawan2[1][2] = "Antonia";
        dataKaryawan2[2][0] = "OP03";
        dataKaryawan2[2][1] = "Crew Junior";
        dataKaryawan2[2][2] = "Putra";
       

        boolean bisaLogin = login();
        if (bisaLogin) {
            menuUtama();
        }
    }
    //fungsi login terdapat inputan username dan passwordnya
    //sesuai dengan array data login 
    //do while di run dulu lalu di cek apakah percobaan kurang dari max percobaan
    //jika berhasil maka masuk maka mengembalikan nilai true dalam variabel bisaLogin
    //dan memanggil fungsi menuUtama
    static boolean login() {
        int percobaanLogin = 0;
        int maxPercobaanLogin = 3;
    
        do {
            System.out.println("\n===================================");
            System.out.print("Masukkan Username: ");
            String inputUsername = scsistem.nextLine();
            System.out.print("Masukkan Password: ");
            String inputPassword = scsistem.nextLine();
    
            if ((inputUsername.equals(user[0][0]) && inputPassword.equals(user[0][1]))) {
                System.out.println("Login berhasil sebagai Manager1!");
                loggedInManager = "manager1";
                return true; // Keluar dari loop setelah login berhasil
            } else if ((inputUsername.equals(user[1][0]) && inputPassword.equals(user[1][1]))) {
                System.out.println("Login berhasil sebagai Manager2!");
                loggedInManager = "manager2";
                return true; // Keluar dari loop setelah login berhasil
            } else {
                System.out.println("Login gagal. Coba lagi.");
                percobaanLogin++;
            }
        } while (percobaanLogin < maxPercobaanLogin);
    
        System.out.println("Maaf, Anda telah melebihi batas percobaan login. Program berakhir.");
        return false;
    }
    //masuk ke menu utama 
    //ada pilihan sistem yang ingin dimasuki
    //menggunakan switch case untuk memanggil fungsi yang dipilih
    static void menuUtama() {
        while (true) {
            System.out.println("===================================");
            System.out.println("\nSelamat datang di Aplikasi Penggajian.");
            int inputSistem;

            System.out.println("\n|===================================|");
            System.out.println("|      Ingin masuk ke sistem apa?   |");
            System.out.println("|===================================|");
            System.out.println("|          1. Data karyawan         |");
            System.out.println("|          2. Penggajian            |");
            System.out.println("|          3. Laporan Bulanan       |");
            System.out.println("|===================================|");
            System.out.print("\nMasukkan sistem yang ingin anda masuki: ");
            inputSistem = scsistem.nextInt();

            switch (inputSistem) {
                case 1:
                    menuDataKaryawan();
                    break;
                case 2:
                    menuPenggajian();
                    break;
                case 3:
                    laporanBulanan(); 
                    break;
                default:
                    System.out.println("Inputan tidak valid. Silakan ");
                    break;
            }
        }
    }
    //menu data karyawan ada beberapa pilihan fitur
    //setiap kali memilih fitur maka dicek manager berapa yang masuk
    //karena nanti data yang ditampilkan akan berbeda
    static void menuDataKaryawan() {
        do {
            int inputmenudata;
            System.out.println("\n|===================================|");
            System.out.println("|        Sistem Data Karyawan       |");
            System.out.println("|===================================|");
            System.out.println("|       1. Data karyawan            |");
            System.out.println("|       2. Tambah Data karyawan     |");
            System.out.println("|       3. Kembali                  |");
            System.out.println("|===================================|");
            System.out.print("\nPilih menu yang ingin anda masuki: ");
            inputmenudata = scmenudata.nextInt();
    
            if (inputmenudata == 1) {
                if (loggedInManager.equals("manager1")) {
                    tampilkanDataKaryawan(dataKaryawan1);
                } else if (loggedInManager.equals("manager2")) {
                    tampilkanDataKaryawan(dataKaryawan2);
                } else {
                    System.out.println("Manager tidak valid.");
                }
            } else if (inputmenudata == 2) {
                if (loggedInManager.equals("manager1")) {
                    tambahDataKaryawan(dataKaryawan1);
                } else if (loggedInManager.equals("manager2")) {
                    tambahDataKaryawan(dataKaryawan2);
                } else {
                    System.out.println("Manager tidak valid.");
                }
            } else if (inputmenudata == 3) {
                break;
            }
        } while (true);
    }
    //fungsi menampilkan  dataKaryawan sesuai dengan manager(1/2)
    static void tampilkanDataKaryawan(String[][] dataKaryawan) {
        System.out.println("\n|============Data Karyawan===========|");
        System.out.println("| ID  |      Jabatan      |   Nama|");
        System.out.println("|====================================|");
    
        for (int i = 0; i < currentIndex; i++) {
            System.out.printf("| %-4s| %-18s| %-9s|%n", dataKaryawan[i][0], dataKaryawan[i][1], dataKaryawan[i][2]);
        }
    
        System.out.println("|===================================|");
    }
    
    static void tambahDataKaryawan(String[][] dataKaryawan) {
        int maxKaryawan = 15;
        boolean tambahData = true;
    
        while (tambahData && currentIndex < maxKaryawan) {
            System.out.println("Masukkan Nama Karyawan: ");
            String nama = inputdata.nextLine();
    
            // Inisialisasi jabatan untuk menghindari error
            String jabatan = "";
    
            // Menentukan pilihan jabatan sesuai dengan manager yang login
            if (loggedInManager.equals("manager1")) {
                System.out.println("1. Manager");
                System.out.println("2. Staff Senior");
                System.out.println("3. Staff Junior");
                System.out.print("Pilih jabatan (1/2/3): ");
                int pilihanJabatan = scsistem.nextInt();
    
                switch (pilihanJabatan) {
                    case 1:
                        jabatan = "Manager";
                        break;
                    case 2:
                        jabatan = "Staff Senior";
                        break;
                    case 3:
                        jabatan = "Staff Junior";
                        break;
                    default:
                        System.out.println("Pilihan jabatan tidak valid. Data karyawan tidak dapat ditambahkan.");
                        tambahData = false;
                        break;
                }
            } else if (loggedInManager.equals("manager2")) {
                System.out.println("1. Head Kitchen");
                System.out.println("2. Crew Senior");
                System.out.println("3. Crew Junior");
                System.out.print("Pilih jabatan (1/2/3): ");
                int pilihanJabatan = scsistem.nextInt();
    
                switch (pilihanJabatan) {
                    case 1:
                        jabatan = "Head Kitchen";
                        break;
                    case 2:
                        jabatan = "Crew Senior";
                        break;
                    case 3:
                        jabatan = "Crew Junior";
                        break;
                    default:
                        System.out.println("Pilihan jabatan tidak valid. Data karyawan tidak dapat ditambahkan.");
                        tambahData = false;
                        break;
                }
            } else {
                System.out.println("Manager tidak valid. Data karyawan tidak dapat ditambahkan.");
                return;
            }
    
            // Masukkan id
            System.out.println("Masukkan id: ");
            String id = inputdata.nextLine();
    
            // Menyimpan data karyawan baru
            dataKaryawan[currentIndex][0] = id;
            dataKaryawan[currentIndex][1] = jabatan;
            dataKaryawan[currentIndex][2] = nama;
    
            currentIndex++;
    
            // Menampilkan data karyawan yang baru saja ditambahkan
            System.out.println("Data Karyawan yang Telah Ditambahkan:");
            System.out.println("Nama: " + nama);
            System.out.println("Jabatan: " + jabatan);
            System.out.println("ID: " + id);
    
            // Tanya apakah ingin menambahkan data karyawan lagi
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
    
    
    //fungsi untuk sistem penggajian
    //data karyawan dan data gaji sesuai dengan manager yang login
    static void menuPenggajian() {
        do {
            int inputmenugaji;
            System.out.println("\n|===================================|");
            System.out.println("|     Sistem Penggajian Karyawan    |");
            System.out.println("|===================================|");
            System.out.println("|       1. Penggajian               |");
            System.out.println("|       2. Kembali                  |");
            System.out.println("|===================================|");
            System.out.print("  \nPilih menu yang ingin anda masuki:   ");
            inputmenugaji = scmenugaji.nextInt();
    
            if (inputmenugaji == 1) {
                if (loggedInManager.equals("manager1")) {
                    // Manager1 login, panggil fungsi untuk dataKaryawan1
                    prosesPenggajianKaryawan(dataKaryawan1, gajiBackoffice);
                } else if (loggedInManager.equals("manager2")) {
                    // Manager2 login, panggil fungsi untuk dataKaryawan2
                    prosesPenggajianKaryawan(dataKaryawan2, gajiOperasional);
                } else {
                    // Tambahkan kondisi sesuai kebutuhan
                    System.out.println("Manager tidak valid.");
                }
            } else if (inputmenugaji == 2) {
                break;
            }
        } while (true);
    }
    
    //proses penggajian mengambil array yang diperlukan dan membuat array baru yang akan diproses dibawah
    static void prosesPenggajianKaryawan(String[][] dataKaryawan, double[][] gajiArray) {
    System.out.println("\n===========Penggajian Karyawan==========");
    System.out.print("Masukkan id karyawan yang ingin digaji: ");
    String idkaryawan = scidbuatgaji.nextLine();

    boolean found = false;
    for (int i = 0; i < currentIndex; i++) {
        String[] karyawan = dataKaryawan[i];
        if (karyawan[0].equals(idkaryawan)) {
            // Menampilkan informasi jika ID ditemukan
            System.out.println("\n===================================");
            System.out.println("| ID  |      Jabatan      |   Nama  |");
            System.out.println("|===================================|");
            System.out.printf("| %-4s| %-18s| %-8s|%n", karyawan[0], karyawan[1], karyawan[2]);
            System.out.println("|===================================|");
            found = true;

            System.out.println("\nProses penggajian dilakukan di sini.");
            
            // Hitung gaji sesuai jabatan
            boolean prosesGaji = false;
            for(int j=0;j<gajiArray.length; j++){
            if(dataKaryawan[i][1].equalsIgnoreCase("manager")||dataKaryawan[i][1].equalsIgnoreCase("head kitchen")){
                j=0;
            }else if(dataKaryawan[i][1].equalsIgnoreCase("staff senior")||dataKaryawan[i][1].equalsIgnoreCase("crew senior")){
                j=1;
            }else if (dataKaryawan[i][1].equalsIgnoreCase("Staff junior")||dataKaryawan[i][1].equalsIgnoreCase("crew junior")){
                j=2;
            }else{
                System.out.println("Jabatan tidak terdeteksi");
            }
            double gajiDasar = gajiArray[j][0];
            double pajak = gajiDasar * gajiArray[j][1];
            double tunjangan = gajiDasar * gajiArray[j][2];
            double gajiBersih = gajiDasar - pajak + tunjangan;

            // Pastikan laporanCount sesuai dengan indeks yang tersedia
            if (laporanCount < laporanGaji.length) {
                laporanGaji[laporanCount][0] = karyawan[0];
                laporanGaji[laporanCount][1] = karyawan[1];
                laporanGaji[laporanCount][2] = karyawan[2];
                laporanGaji[laporanCount][3] = String.valueOf(gajiDasar);
                laporanGaji[laporanCount][4] = String.valueOf(pajak);
                laporanGaji[laporanCount][5] = String.valueOf(tunjangan);
                laporanGaji[laporanCount][6] = String.valueOf(gajiBersih);

                // Tampilkan informasi gaji
                System.out.println("======Laporan Gaji======");
                System.out.println("Gaji Dasar   : " + gajiDasar);
                System.out.println("Pajak        : " + pajak);
                System.out.println("Tunjangan    : " + tunjangan);
                System.out.println("Total Gaji   : " + gajiBersih);

                System.out.println("\n======Perhitungan Lembur======");
                System.out.print("  Masukkan Jam Lembur :");
                int jmlembur = scjamlembur.nextInt();

                if (jmlembur > 0) {
                    int bonus = 20000;
                    double gajiLembur = jmlembur * bonus;
                    double totalGaji = gajiBersih + gajiLembur;
                    System.out.println("Gaji Lembur Anda = " + gajiLembur);
                    System.out.println("\nTOTAL GAJI ANDA  = " + totalGaji);
                    System.out.println("=====================================");
                    laporanGaji[laporanCount][7] = String.valueOf(gajiLembur);
                    laporanGaji[laporanCount][8] = String.valueOf(totalGaji);
                } else {
                    System.out.println("\nTOTAL GAJI ANDA = " + gajiBersih);
                    System.out.println("=====================================");
                }
                laporanCount++;
            } else {
                System.out.println("Array laporanGaji sudah penuh. Tidak dapat menambahkan laporan lagi.");
            }
            break;
        } 
        }
    }

    if (!found) {
        System.out.println("Karyawan dengan ID " + idkaryawan + " tidak ditemukan.");
    }
}

    
    //cetak laporan bulanan setelah dilakukan penggajian
    static void laporanBulanan() {
        System.out.println("\n========================================Laporan Bulanan======================================================");
        System.out.println("| ID  |      Jabatan      |   Nama  | Gaji Dasar | Pajak | Tunjangan | Gaji Bersih | Gaji Lembur | Total Gaji |");
        System.out.println("|=============================================================================================================|");
        for (int i = 0; i < laporanCount; i++) {
            System.out.printf("| %-4s| %-18s| %-8s| %-10s| %-5s| %-9s| %-11s| %-12s| %-10s|%n",
                    laporanGaji[i][0], laporanGaji[i][1], laporanGaji[i][2],
                    laporanGaji[i][3], laporanGaji[i][4], laporanGaji[i][5],
                    laporanGaji[i][6], laporanGaji[i][7], laporanGaji[i][8]);
        }
        System.out.println("|============================================================================================================|");
        
    } 
    

}