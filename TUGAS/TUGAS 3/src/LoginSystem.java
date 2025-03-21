import java.util.Scanner;

// Kelas User sebagai superclass
class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public boolean login(String inputNim) {
        return this.nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Informasi Pengguna: " + nama);
    }
}

// Kelas Admin sebagai subclass dari User
class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void displayAdminInfo() {
        System.out.println("Login Admin berhasil: " + getNama());
    }
}

// Kelas Mahasiswa sebagai subclass dari User
class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    public boolean loginMahasiswa(String inputNim) {
        return super.login(inputNim);
    }

    public void displayMahasiswaInfo() {
        System.out.println("Login Mahasiswa berhasil: " + getNama());
    }
}

// Kelas LoginSystem sebagai program utama
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin Satu", "0001", "admin", "admin123");
        Mahasiswa mahasiswa = new Mahasiswa("Aqil", "242");

        System.out.println("Pilih login: 1. Admin  2. Mahasiswa");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {
                admin.displayAdminInfo();
            } else {
                System.out.println("Login Admin gagal.");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (mahasiswa.loginMahasiswa(nim)) {
                mahasiswa.displayMahasiswaInfo();
            } else {
                System.out.println("Login Mahasiswa gagal.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}