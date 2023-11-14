import java.util.Scanner;

public class input_data {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nama, jabatan;
        int masaKerja;
        boolean tambahData = true;

        while (tambahData) {
            System.out.println("-----INPUT DATA KARYAWAN-----");
            System.out.println("Masukkan Nama Karyawan: ");
            nama = input.nextLine();
            System.out.println("Masukkan Jabatan Karyawan: ");
            jabatan = input.nextLine();
            System.out.println("Masukkan Masa Kerja (dalam tahun): ");
            masaKerja = input.nextInt();
            
            System.out.println("Data Karyawan yang Telah Ditambahkan:");
            System.out.println("Nama: " + nama);
            System.out.println("Jabatan: " + jabatan);
            System.out.println("Masa Kerja: " + masaKerja + " tahun");

            System.out.print("Tambah data karyawan lainnya? (ya/tidak): ");
            String jawaban = input.next();

            if (jawaban.equalsIgnoreCase("ya")) {
            System.out.println("Silakan masukkan data karyawan berikutnya");
            } else {
            System.out.println("Jawaban tidak valid. Terimakasih telah menginput data.");
                tambahData = false;
            }
        }
    }
}