import java.util.Scanner;

// SUPERCLASS: User
class User {
    // Enkapsulasi: atribut diset private
    private String nama;
    private String nim;

    // Constructor
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter dan Setter (Encapsulation)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Method login (akan dioverride oleh subclass)
    public boolean login(String input1, String input2) {
        return false; // default
    }

    // Menampilkan info user
    public void displayInfo() {
        System.out.println("Informasi Pengguna: " + nama + " - " + nim);
    }
}

// SUBCLASS: Admin
class Admin extends User {
    // Tambahan atribut Admin
    private String username;
    private String password;

    // Constructor: menggunakan super untuk inisialisasi nama dan nim
    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim); // panggil constructor dari User
        this.username = username;
        this.password = password;
    }

    // Override method login: cocokkan username dan password
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    // Override method displayInfo
    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Selamat datang, Admin: " + getNama() + " | NIM: " + getNim());
    }
}

// SUBCLASS: Mahasiswa
class Mahasiswa extends User {

    // Constructor: menggunakan super
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    // Override login: cocokkan nama dan nim
    @Override
    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(getNama()) && inputNim.equals(getNim());
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Selamat datang, Mahasiswa: " + getNama() + " | NIM: " + getNim());
    }
}

// Kelas Utama (main)
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data dummy (sementara)
        Admin admin = new Admin("Admin Satu", "001", "admin123", "pass123");
        Mahasiswa mahasiswa = new Mahasiswa("aqil", "242");

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline

        boolean isLoggedIn = false;

        // Login Admin
        if (choice == 1) {
            System.out.print("Masukkan Username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan Password: ");
            String password = scanner.nextLine();

            isLoggedIn = admin.login(username, password);

            if (isLoggedIn) {
                admin.displayInfo();
            } else {
                System.out.println("Login Admin gagal! Username atau password salah.");
            }

            // Login Mahasiswa
        } else if (choice == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            isLoggedIn = mahasiswa.login(nama, nim);

            if (isLoggedIn) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login Mahasiswa gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}