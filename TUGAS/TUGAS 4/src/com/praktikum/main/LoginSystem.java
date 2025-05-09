package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dummy data
        Admin admin = new Admin("Admin Satu", "001", "admin123", "pass123");
        Mahasiswa mahasiswa = new Mahasiswa("aqil", "242");

        User user = null;

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        boolean isLoggedIn = false;

        if (choice == 1) {
            System.out.print("Masukkan Username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan Password: ");
            String password = scanner.nextLine();
            isLoggedIn = admin.login(username, password);
            if (isLoggedIn) user = admin;
        } else if (choice == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            isLoggedIn = mahasiswa.login(nama, nim);
            if (isLoggedIn) user = mahasiswa;
        }

        if (isLoggedIn && user != null) {
            user.displayInfo();
            user.displayAppMenu(); // Polymorphic call
        } else {
            System.out.println("Login gagal!");
        }

        scanner.close();
    }
}
