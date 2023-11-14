import java.util.Scanner;
public class perhitungan2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int gajiLembur;
    int bonus=20000;
    double totalGaji;

    System.out.print("Masukkan Next Gaji :");
    int nextgaji = sc.nextInt();
    System.out.print("Masukkan Jam Lembur :");
    int jamLembur = sc.nextInt();

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
