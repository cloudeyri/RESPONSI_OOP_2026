public class PasienRawatInap extends Pasien implements Pemeriksaan, Pembayaran {
    private int lamaInap;
    private String nomorKamar;
    private String jenisKamar;

    public PasienRawatInap(String noRekamMedis, String nama, String keluhan, int lamaInap, String nomorKamar, String jenisKamar) {
        super(noRekamMedis, nama, keluhan);
        this.lamaInap = lamaInap;
        this.nomorKamar = nomorKamar;
        this.jenisKamar = jenisKamar;
    }

    public PasienRawatInap(String noRekamMedis, String nama, String keluhan, int tagihanAwal, int lamaInap, String nomorKamar, String jenisKamar) {
        super(noRekamMedis, nama, keluhan, tagihanAwal);
        this.lamaInap = lamaInap;
        this.nomorKamar = nomorKamar;
        this.jenisKamar = jenisKamar;
    }

    public int getLamaInap() {
        return this.lamaInap;
    }

    public void setLamaInap(int lamaInap) {
        this.lamaInap = lamaInap;
    }

    public String getNomorKamar() {
        return this.nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public String getJenisKamar() {
        return this.jenisKamar;
    }

    public void setJenisKamar(String jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    public int hitungBiayaKamar(int tarifPerHari) {
        return tarifPerHari * this.lamaInap;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis    : Rawat Inap (" + this.lamaInap + " hari)");
        System.out.println("Kamar    : " + this.nomorKamar + " - " + this.jenisKamar);
    }

    @Override
    public void hitungBiayaPerawatan(int tarifKamarPerHari) {
        if (tarifKamarPerHari > 0 && this.lamaInap > 0) {
            int totalBiayaKamar = hitungBiayaKamar(tarifKamarPerHari);
            setTagihan(getTagihan() + totalBiayaKamar);
            System.out.println("Biaya kamar " + this.jenisKamar + " (" + this.lamaInap + " hari = Rp" + totalBiayaKamar + ") ditambahkan.");
        } else {
            System.out.println("Tarif kamar atau lama inap tidak valid!");
        }
    }

    @Override
    public void periksa() {
        System.out.println("Dokter visit ke kamar " + this.nomorKamar + " memeriksa pasien " + getNama() + " dengan Keluhan: " + getKeluhan());
    }

    @Override
    public void bayar(int nominal) {
        System.out.println("[" + getNama() + "] Nominal dibayarkan: Rp" + nominal);
        if (nominal <= 0) {
            System.out.println("Nominal pembayaran tidak valid!");
        } else if (getTagihan() == 0) {
            System.out.println("Tagihan sudah lunas sebelumnya.");
        } else if (nominal >= getTagihan()) {
            int kembalian = nominal - getTagihan();
            setTagihan(0);
            System.out.println("Tagihan Rawat Inap lunas! Kembalian: Rp" + kembalian);
        } else {
            setTagihan(getTagihan() - nominal);
            System.out.println("Cicilan diterima. Sisa tagihan Rawat Inap: Rp" + getTagihan());
        }
    }
}
