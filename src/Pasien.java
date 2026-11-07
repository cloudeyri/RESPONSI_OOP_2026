public abstract class Pasien {
    public static final String NAMA_RS = "RSUD Margono Soekarjo";
    public static final int BIAYA_ADMINISTRASI = 25000;

    private final String noRekamMedis;
    private String nama;
    private String keluhan;
    private int tagihan;

    public Pasien(String noRekamMedis, String nama, String keluhan) {
        this.noRekamMedis = noRekamMedis;
        this.nama = nama;
        this.keluhan = keluhan;
        this.tagihan = BIAYA_ADMINISTRASI;
    }

    public Pasien(String noRekamMedis, String nama, String keluhan, int tagihanAwal) {
        this(noRekamMedis, nama, keluhan);
        this.tagihan += tagihanAwal;
    }

    public String getNoRekamMedis() {
        return this.noRekamMedis;
    }

    public String getNama() {
        return this.nama;
    }

    public String getKeluhan() {
        return this.keluhan;
    }

    public int getTagihan() {
        return this.tagihan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public void setTagihan(int tagihan) {
        this.tagihan = tagihan;
    }

    public void tampilkanInfo() {
        System.out.println("==== " + NAMA_RS + " ====");
        System.out.println("No       : " + this.noRekamMedis);
        System.out.println("Nama     : " + this.nama);
        System.out.println("Keluhan  : " + this.keluhan);
        System.out.println("Tagihan  : Rp" + this.tagihan);
    }

    public abstract void hitungBiayaPerawatan(int biaya);
}
