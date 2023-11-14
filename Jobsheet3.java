import java.util.Scanner;
public class Jobsheet3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int gajipokok, bonus, sanksi;
        float slipgaji;

        System.out.println("Masukkan gaji pokok: ");
        gajipokok = sc.nextInt();
        System.out.println("Masukkan berapa hari alpha: ");
        sanksi = sc.nextInt();
        System.out.println("Masukkan berapa bonus: ");
        bonus = sc.nextInt();

        slipgaji = gajipokok + bonus - sanksi * 150000;

        System.out.println("Slip gaji :" +slipgaji );
    }
    
}