import java.util.Scanner;

public class fiturjabatan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih kategori jabatan:");
        System.out.println("Manager");
        System.out.println("Admin");
        System.out.println("Chef");
        System.out.println("Cashier");
        System.out.print("Masukkan Kategori Jabatan: ");
        String kategori = input.nextLine();

        double gajiPokok = 0;
        double pajak = 0;

        switch (kategori) {
            case "Manager":
                gajiPokok = 8000000; // Gaji pokok untuk Manager
                pajak = 0.1 * gajiPokok; // Pajak 10% dari gaji pokok
                break;
            case "Admin":
                gajiPokok = 5000000; // Gaji pokok untuk Admin
                pajak = 0.08 * gajiPokok; // Pajak 8% dari gaji pokok
                break;
            case "Chef":
                gajiPokok = 4000000; // Gaji pokok untuk Chef
                pajak = 0.05 * gajiPokok; // Pajak 5% dari gaji pokok
                break;
            case "Cashier":
                gajiPokok = 2000000; // Gaji pokok untuk Cashier
                pajak = 0.05 * gajiPokok; // Pajak 5% dari gaji pokok
                break;
            default:
                System.out.println("Maaf, Kategori Jabatan Tidak Valid");
                return; // Menghentikan program jika kategori jabatan tidak valid
        }

        System.out.println("Gaji Pokok: " + gajiPokok);
        System.out.println("Pajak: " + pajak);
    }
}
