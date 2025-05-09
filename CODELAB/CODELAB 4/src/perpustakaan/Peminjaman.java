package perpustakaan;

public class Peminjaman {
    private Buku buku;
    private Anggota anggota;
    private int lamaPinjam;

    public Peminjaman(Buku buku, Anggota anggota, int lamaPinjam) {
        this.buku = buku;
        this.anggota = anggota;
        this.lamaPinjam = lamaPinjam;
    }

    public void tampilkanDetail() {
        anggota.displayInfo();
        buku.displayInfo();
        System.out.println("Lama meminjam: " + lamaPinjam + " hari");
    }
}
