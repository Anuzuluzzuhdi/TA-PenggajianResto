import java.util.Scanner;

//public class coba_gadjian {
    class Karyawan {
        String nama;
        String jabatan;
        double gajiPokok;
        double tunjangan;
        double bonusLembur;
        double pajak;
        double totalGaji;
    
        Karyawan(String nama, String jabatan, double gajiPokok) {
            this.nama = nama;
            this.jabatan = jabatan;
            this.gajiPokok = gajiPokok;
        }
    
        void hitungTunjangan() {
            // Hitung tunjangan sesuai dengan jabatan atau kategori
            // Anda dapat menambahkan logika tambahan di sini
            if (jabatan.equalsIgnoreCase("manager")) {
                tunjangan = 0.2 * gajiPokok;
            } else if (jabatan.equalsIgnoreCase("staff")) {
                tunjangan = 0.1 * gajiPokok;
            } else {
                tunjangan = 0.05 * gajiPokok;
            }
        }
    
        void hitungBonusLembur(double jamLembur) {
            // Hitung bonus lembur (misalnya, per jam lembur)
            bonusLembur = 20 * jamLembur;
        }
    
        void hitungPajak() {
            // Hitung pajak (misalnya, 10% dari total gaji)
            pajak = 0.1 * (gajiPokok + tunjangan + bonusLembur);
        }
    
        void hitungTotalGaji() {
            // Hitung total gaji
            totalGaji = gajiPokok + tunjangan + bonusLembur - pajak;
        }
    
        void cetakSlipGaji() {
            // Cetak slip gaji
            System.out.println("===== SLIP GAJI =====");
            System.out.println("Nama: " + nama);
            System.out.println("Jabatan: " + jabatan);
            System.out.println("Gaji Pokok: " + gajiPokok);
            System.out.println("Tunjangan: " + tunjangan);
            System.out.println("Bonus Lembur: " + bonusLembur);
            System.out.println("Pajak: " + pajak);
            System.out.println("Total Gaji: " + totalGaji);
        }
    }
    
    public class coba_gadjian {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            
            System.out.println("===========PENGAJIAN RESTORAN===========");
            System.out.print("Masukkan nama karyawan: ");
            String nama = input.nextLine();
            System.out.print("Masukkan jabatan (manager/staff/karyawan): ");
            String jabatan = input.nextLine();
            System.out.print("Masukkan gaji pokok: ");
            double gajiPokok = input.nextDouble();
            System.out.print("Masukkan jam lembur: ");
            double jamLembur = input.nextDouble();
    
            Karyawan karyawan = new Karyawan(nama, jabatan, gajiPokok);
            karyawan.hitungTunjangan();
            karyawan.hitungBonusLembur(jamLembur);
            karyawan.hitungPajak();
            karyawan.hitungTotalGaji();
            karyawan.cetakSlipGaji();
        }
    }
//}
