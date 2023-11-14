import java.util.Scanner;
public class Jobsheet4 {
    public static void main(String[] args) {
        Scanner input =new Scanner (System.in);
        int gajipokok, bonus, alpha, sanksi;
        double slipgaji;
        System.out.println("Masukkan gaji pokok anda");
        gajipokok=input.nextInt();
        System.out.println("Masukkan bonus");
        bonus=input.nextInt();
        System.out.println("Masukkan berapa hari alpha");
        alpha=input.nextInt();
        sanksi=input.nextInt();
        slipgaji=input.nextDouble();
        slipgaji=gajipokok+bonus-alpha*sanksi;
        System.out.println("Slip gaji anda adalah:");
    }
}