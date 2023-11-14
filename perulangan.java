import java.util.Scanner;

public class perulangan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = "admin";
        String password = "password";
        boolean isLoggedIn = false;

        do {
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
        } while (!isLoggedIn);
        
        // Tempatkan kode berikutnya setelah login berhasil.
        System.out.println("Selamat datang di aplikasi kami.");
    }
}
