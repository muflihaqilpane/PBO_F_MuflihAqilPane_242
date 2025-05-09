package perpustakaan;

public class Anggota {
    private String nama;
    private String id;

    public Anggota(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Nama Anggota: " + nama);
        System.out.println("ID Anggota: " + id);
    }

    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }
}
