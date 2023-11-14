import java.util.Scanner;

public class NesLoop_DataKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int maxEmployees = 15;
        String[][] dataKaryawan = new String[maxEmployees][3]; // {nama, jabatan, masaKerja}
        int currentIndex = 0;

        boolean tambahData = true;

        while (tambahData && currentIndex < maxEmployees) {
            for (int i = 0; i < 3; i++) {
                String dataLabel = i == 0 ? "Nama" : (i == 1 ? "Jabatan" : "Masa Kerja (dalam tahun)");
                System.out.print("Masukkan " + dataLabel + " Karyawan: ");
                String inputData = input.nextLine();
                dataKaryawan[currentIndex][i] = inputData;
            }
            currentIndex++;

            System.out.println("Data Karyawan yang Telah Ditambahkan:");
            System.out.println("Nama: " + dataKaryawan[currentIndex - 1][0]);
            System.out.println("Jabatan: " + dataKaryawan[currentIndex - 1][1]);
            System.out.println("Masa Kerja: " + dataKaryawan[currentIndex - 1][2] + " tahun");

            System.out.print("Tambah data karyawan lainnya? (ya/tidak): ");
            String jawaban = input.nextLine();

            if (!jawaban.equalsIgnoreCase("ya")) {
                tambahData = false;
            }
        }

        System.out.println("Data Karyawan yang Telah Dimasukkan:");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println("Nama: " + dataKaryawan[i][0]);
            System.out.println("Jabatan: " + dataKaryawan[i][1]);
            System.out.println("Masa Kerja: " + dataKaryawan[i][2] + " tahun");
        }
    }
}