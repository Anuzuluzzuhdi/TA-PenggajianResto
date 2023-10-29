import java.util.Scanner;
public class array_lembur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String namaKaryawan[];
        namaKaryawan = new String[4];

            for (int i = 0; i < namaKaryawan.length; i++){
                System.out.println("Masukkan Nama Karyawan :");
                namaKaryawan[i] = sc.nextLine();
            
            }

            for (int i = 0; i<namaKaryawan.length; i++){
                System.out.println("Daftar Nama Karyawan "+ i +" Nama : "+namaKaryawan[i]);
            }
    }
}
