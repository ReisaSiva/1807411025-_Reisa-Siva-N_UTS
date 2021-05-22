package pnj.uts.ti.reisasiva.database;

import android.provider.BaseColumns;

public class DatabaseContract {
    static String TABLE_NAME = "alumni";

    public static final class AlumniColumns implements BaseColumns {
        public static String NIM = "nim";
        public static String NAMA = "nama";
        public static String TEMPAT_LAHIR = "tempatLahir";
        public static String TANGGAL_LAHIR = "tanggalLahir";
        public static String ALAMAT = "alamat";
        public static String AGAMA = "agama";
        public static String NOMOR_HP = "nomorHp";
        public static String TAHUN_MASUK = "tahunMasuk";
        public static String TAHUN_LULUS = "tahunLulus";
        public static String PEKERJAAN = "pekerjaan";
        public static String JABATAN = "jabatan";
    }
}
