import java.util.Scanner;

public class LoginSystem {

    // Kelas Admin
    static class Admin {
        private String username = "admin";
        private String password = "admin123";

        public boolean login(String username, String password) {
            if (this.username.equals(username) && this.password.equals(password)) {
                System.out.println("Login Admin berhasil!");
                return true;
            } else {
                System.out.println("Username atau password Admin salah.");
                return false;
            }
        }
    }

    // Kelas Mahasiswa
    static class Mahasiswa {
        private String nama = "Muflih Aqil Pane";
        private String nim = "202410370110242";

        public boolean login(String nama, String nim) {
            if (this.nama.equalsIgnoreCase(nama) && this.nim.equals(nim)) {
                System.out.println("Login Mahasiswa berhasil!");
                displayInfo();
                return true;
            } else {
                System.out.println("Nama atau NIM Mahasiswa salah.");
                return false;
            }
        }

        public void displayInfo() {
            System.out.println("Nama Mahasiswa : " + nama);
            System.out.println("NIM Mahasiswa  : " + nim);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("=== Selamat Datang di Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi login (1/2): ");
        String pilihan = scanner.nextLine();

        switch (pilihan) {
            case "1":
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                admin.login(username, password);
                break;
            case "2":
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                mahasiswa.login(nama, nim);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        scanner.close();
    }
}