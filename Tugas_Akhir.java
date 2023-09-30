import java.util.Scanner;
public class Tugas_Akhir {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int gajipokok, bonus, alpha; 
       int sanksi=150000;
       double slipgaji;

       System.out.println("===========PENGGAJIAN RESTORAN===========");
        // if (golongan 1)

       System.out.println("Masukkan Gaji Pokok Anda : " );
       gajipokok = sc.nextInt();
       System.out.println("Masukkan Jumlah Hari Tidak Masuk Kerja: ");
       alpha = sc.nextInt();
       System.out.println("Masukkan Jumlah Bonus Anda Bulan Ini: ");
       bonus = sc.nextInt();

       slipgaji = gajipokok + bonus -(alpha*sanksi);

       System.out.println("Slip gaji anda adalah :" +slipgaji );

       //output
       //===========PENGAJIAN RESTORAN===========
        //Masukkan Gaji Pokok Anda :
        //5000000

        //Masukkan Jumlah Hari Tidak Masuk Kerja:
        //24

        //Masukkan Jumlah Bonus Anda Bulan Ini:
        //2

        //Slip gaji anda adalah :1400002.0
    }
}
