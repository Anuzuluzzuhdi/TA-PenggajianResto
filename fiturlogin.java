import java.util.Scanner;

public class fiturlogin {
    public static void main(String[] args) {
        // Informasi pengguna (nama pengguna dan kata sandi)
        String username1 = "manager1";
        String password1 = "password1";
        String username2 = "manager2";
        String password2 = "password2";

        // Membuat objek Scanner
        Scanner scanner = new Scanner(System.in);

        // Meminta pengguna untuk memasukkan nama pengguna dan kata sandi
        System.out.print("Masukkan nama pengguna: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Masukkan kata sandi: ");
        String passwordInput = scanner.nextLine();

        // Memeriksa kecocokan nama pengguna dan kata sandi
        boolean loginSuccess = false;
        if (usernameInput.equals(username1) && passwordInput.equals(password1)) {
            loginSuccess = true;
        } else if (usernameInput.equals(username2) && passwordInput.equals(password2)) {
            loginSuccess = true;
        }

        // Menampilkan pesan hasil login
        if (loginSuccess) {
            System.out.println("Login berhasil. Selamat datang, " + usernameInput + "!");
        } else {
            System.out.println("Login gagal. Nama pengguna atau kata sandi salah.");
        }

        // Menutup scanner
        scanner.close();
    }
}