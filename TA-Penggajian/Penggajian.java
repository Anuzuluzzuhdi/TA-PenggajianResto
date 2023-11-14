import java.util.Scanner;
public class Penggajian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = "admin";
        String password = "password";
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.print("Username: ");
            String inputUsername = input.nextLine();
            System.out.print("Password: ");
            String inputPassword = input.nextLine();

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("Login berhasil!");
                isLoggedIn = true;
            } else {
                System.out.println("Login gagal. Coba lagi.");
            }
        }

        if (isLoggedIn) {
            System.out.println("Selamat datang di aplikasi kami.");

            // Program penggajian karyawan dapat dimasukkan di sini
            // ...

            String divisi, jabatan, senior;
        int gajipokok;
        double pajak, tunjangan, nextgaji;

        System.out.println("|-------------------------------|");
        System.out.println("|                               |");
        System.out.println("|      Kategori Anda adalah ?   |");
        System.out.println("|                               |");
        System.out.println("|-------------------------------|");
        System.out.println("|                               |");
        System.out.println("|          Backoffice           |");
        System.out.println("|          Operasional          |");
        System.out.println("|                               |");
        System.out.println("|-------------------------------|");
        System.out.println("Masukkan divisi anda?");
        divisi = input.nextLine();

        if (divisi.equalsIgnoreCase("backoffice"))
        {
            System.out.println("|-------------------------------|");
            System.out.println("|                               |");
            System.out.println("|      Jabatan Anda adalah ?    |");
            System.out.println("|                               |");
            System.out.println("|-------------------------------|");
            System.out.println("|                               |");
            System.out.println("|           Manager             |");
            System.out.println("|            Staff              |");
            System.out.println("|                               |");
            System.out.println("|-------------------------------|");
            System.out.println("---Masukkan jabatan anda?---");
            jabatan = input.nextLine();

            if (jabatan.equalsIgnoreCase("manager"))
            {
                gajipokok =+ 8000000;
                pajak =+ 0.05;
                tunjangan = 0.05;

                nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                System.out.println("Gaji anda adalah = " +nextgaji);


            }
            else if (jabatan.equalsIgnoreCase("staff"))
            {
                System.out.println("-----Apakah anda senior?----- ");
                System.out.println("Senior");
                System.out.println("Junior");
                jabatan = input.nextLine();
                if (jabatan.equalsIgnoreCase("Senior"))
                {
                    gajipokok =+ 3000000;
                    pajak =+ 0.04;
                    tunjangan = 0.04;

                    nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    System.out.println("Gaji anda adalah = " +nextgaji);
                }
                else if (jabatan.equalsIgnoreCase("Junior"))
                {
                    gajipokok =+ 2000000;
                    pajak =+ 0.03;
                    tunjangan = 0.03;

                    nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    System.out.println("Gaji anda adalah = " +nextgaji);
                }                

            }
        }
        else if (divisi.equalsIgnoreCase("operasional"))
        {

            System.out.println("|-------------------------------|");
            System.out.println("|                               |");
            System.out.println("|      Jabatan Anda adalah ?    |");
            System.out.println("|                               |");
            System.out.println("|-------------------------------|");
            System.out.println("|                               |");
            System.out.println("|          Head Kitchen         |");
            System.out.println("|          Crew                 |");
            System.out.println("|                               |");
            System.out.println("|-------------------------------|");
            System.out.println("---Masukkan jabatan anda?---");
            jabatan = input.nextLine();
            if (jabatan.equalsIgnoreCase("head kitchen"))
            {
                gajipokok =+ 3500000;
                pajak =+ 0.05;
                tunjangan = 0.05;

                nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                System.out.println("Gaji anda adalah = " +nextgaji);
            }
            else if (jabatan.equalsIgnoreCase("crew"))
            {
                System.out.println("-----Apakah anda senior?-----");
                System.out.println("Senior");
                System.out.println("Junior");
                jabatan = input.nextLine();
                if (jabatan.equalsIgnoreCase("Senior"))
                {
                    gajipokok =+ 2500000;
                    pajak =+ 0.04;
                    tunjangan = 0.04;

                    nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    System.out.println("Gaji anda adalah = " +nextgaji);
                }
                else if (jabatan.equalsIgnoreCase("Junior"))
                {
                    gajipokok =+ 1500000;
                    pajak =+ 0.03;
                    tunjangan = 0.03;

                    nextgaji = gajipokok - (gajipokok * pajak) + (gajipokok * tunjangan);
                    System.out.println("Gaji Bersih Anda Adalah = " +nextgaji);
                }                 
            }
        }
        else 
        {
            System.out.println("Kategori yang anda masukan salah!");
        }
        }
    }
}