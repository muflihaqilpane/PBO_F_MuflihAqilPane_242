package perpustakaan;

public class Fiksi extends Buku {
    public Fiksi(String judul, String penulis) {
        super(judul, penulis);
    }

    @Override
    public void displayInfo() {
        System.out.println("Fiksi: " + judul + " oleh " + penulis);
    }
}
