package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        // Buku-buku
        Fiksi buku1 = new Fiksi("Negeri Lima Menara", "Ahmad Fuadi");
        NonFiksi buku2 = new NonFiksi("Tips Sukses Menjadi Mahasiswa", "Dewi Anggraeni");

        // Dua anggota: Aqil dan Vero
        Anggota aqil = new Anggota("Aqil", "242");
        Anggota vero = new Anggota("Vero", "239");

        // Peminjaman
        Peminjaman pinjam1 = new Peminjaman(buku1, aqil, 3);
        Peminjaman pinjam2 = new Peminjaman(buku2, vero, 7);

        // Output
        System.out.println("== Detail Peminjaman 1 ==");
        pinjam1.tampilkanDetail();
        System.out.println("\n== Detail Peminjaman 2 ==");
        pinjam2.tampilkanDetail();
    }
}
