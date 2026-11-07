public class PasienRawatJalan extends Pasien implements Pemeriksaan, Pembayaran {
    private String poliTujuan;
    private int jumlahKunjungan;

    public PasienRawatJalan(String noRekamMedis, String nama, String keluhan, String poliTujuan) {
        super(noRekamMedis, nama, keluhan);
        this.poliTujuan = poliTujuan;
        this.jumlahKunjungan = 0;
    }

    public PasienRawatJalan(String noRekamMedis, String nama, String keluhan, int tagihanAwal, String poliTujuan) {
        super(noRekamMedis, nama, keluhan, tagihanAwal);
        this.poliTujuan = poliTujuan;
        this.jumlahKunjungan = 0;
    }

    public String getPoliTujuan() {
        return this.poliTujuan;
    }

    public void setPoliTujuan(String poliTujuan) {
        this.poliTujuan = poliTujuan;
    }

    public int getJumlahKunjungan() {
        return this.jumlahKunjungan;
    }

    public void setJumlahKunjungan(int jumlahKunjungan) {
        this.jumlahKunjungan = jumlahKunjungan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis    : Rawat Jalan (" + this.poliTujuan + ")");
        System.out.println("Kunjungan: " + this.jumlahKunjungan + " kali");
    }

    @Override
    public void hitungBiayaPerawatan(int biaya) {
        if (biaya <= 0) {
            System.out.println("Biaya perawatan tidak valid!");
        } else if (this.jumlahKunjungan >= 3) {
            int diskon = biaya / 2;
            setTagihan(getTagihan() + diskon);
            this.jumlahKunjungan++;
            System.out.println("Kontrol lanjutan, diskon 50%: Rp" + diskon);
        } else {
            setTagihan(getTagihan() + biaya);
            this.jumlahKunjungan++;
            System.out.println("Biaya perawatan poli Rp" + biaya + " ditambahkan.");
        }
    }

    @Override
    public void periksa() {
        System.out.println("Dokter " + this.poliTujuan + " memeriksa pasien " + getNama() + " dengan keluhan: " + getKeluhan());
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
            System.out.println("Pembayaran Rawat Jalan lunas! Kembalian: Rp" + kembalian);
        } else {
            System.out.println("Rawat jalan wajib bayar penuh. Tagihan: Rp" + getTagihan());
        }
    }
}
