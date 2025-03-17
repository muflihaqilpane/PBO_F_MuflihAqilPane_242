class RekeningBank {
    String nomorRekening;
    String namaPemilik;
    double saldo;

    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }


    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik : " + namaPemilik);
        System.out.println("Saldo        : Rp" + saldo);
        System.out.println();
    }


    public void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }


    public void tarikUang(double jumlah) {
        if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        } else {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        RekeningBank rekening1 = new RekeningBank("202410370110242", "Aqil", 500000);
        RekeningBank rekening2 = new RekeningBank("202410370110268", "Rifadz", 1000000);


        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        rekening1.setorUang(700000);
        rekening2.tarikUang(500000);
        rekening1.tarikUang(800000);
        rekening2.tarikUang(300000);

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}