public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("SISTEM INFORMASI " + Pasien.NAMA_RS.toUpperCase());
        System.out.println("Biaya Administrasi Pendaftaran: Rp" + Pasien.BIAYA_ADMINISTRASI);
        System.out.println("==================================================\n");

        System.out.println("=== TAHAP 1: LOKET PENDAFTARAN PASIEN ===");
        PasienRawatJalan pasien1 = new PasienRawatJalan("RM-001", "Kaloka Aswara", "Demam dan Batuk", "Poli Umum");
        PasienRawatJalan pasien3 = new PasienRawatJalan("RM-003", "Anindya Dewi", "Pusing", 50000, "Poli Saraf");
        pasien1.setJumlahKunjungan(3);
        pasien1.tampilkanInfo();
        System.out.println();
        pasien3.tampilkanInfo();
        System.out.println();

        PasienRawatInap pasien2 = new PasienRawatInap("RM-002", "Kamala Sari", "Demam Berdarah", 150000, 3, "Mawar-04", "Kelas VIP");
        PasienRawatInap pasien4 = new PasienRawatInap("RM-004", "Handi Prabu", "Tifus", 2, "Melati-01", "Kelas 1");
        pasien2.setLamaInap(4);
        pasien2.tampilkanInfo();
        System.out.println();
        pasien4.tampilkanInfo();
        System.out.println("--------------------------------------------------\n");

        System.out.println("=== TAHAP 2: RUANG PEMERIKSAAN MEDIS ===");
        Pemeriksaan periksa1 = pasien1;
        periksa1.periksa();

        Pemeriksaan periksa3 = pasien3;
        periksa3.periksa();

        Pemeriksaan periksa2 = pasien2;
        periksa2.periksa();

        Pemeriksaan periksa4 = pasien4;
        periksa4.periksa();
        System.out.println("--------------------------------------------------\n");

        System.out.println("=== TAHAP 3: LOKET KASIR & PEMBAYARAN ===");
        pasien1.hitungBiayaPerawatan(80000);
        System.out.println("Total Tagihan Kaloka: Rp" + pasien1.getTagihan());
        Pembayaran kasir1 = pasien1;
        kasir1.bayar(30000);
        kasir1.bayar(65000);
        kasir1.bayar(10000);
        System.out.println();


        pasien3.hitungBiayaPerawatan(60000);
        System.out.println("Total Tagihan Anin: Rp" + pasien3.getTagihan());
        Pembayaran kasir3 = pasien3;
        kasir3.bayar(150000);
        System.out.println();

        pasien2.hitungBiayaPerawatan(300000);
        System.out.println("Total Tagihan Kamala: Rp" + pasien2.getTagihan());
        Pembayaran kasir2 = pasien2;
        kasir2.bayar(500000);
        kasir2.bayar(875000);
        System.out.println();

        pasien4.hitungBiayaPerawatan(150000);
        System.out.println("Total Tagihan Handi: Rp" + pasien4.getTagihan());
        Pembayaran kasir4 = pasien4;
        kasir4.bayar(325000);
        System.out.println("==================================================");
    }
}
