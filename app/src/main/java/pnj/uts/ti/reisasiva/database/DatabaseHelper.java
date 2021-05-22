package pnj.uts.ti.reisasiva.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "dbutsapp";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_ALUMNI = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_NAME,
            DatabaseContract.AlumniColumns._ID,
            DatabaseContract.AlumniColumns.NIM,
            DatabaseContract.AlumniColumns.NAMA,
            DatabaseContract.AlumniColumns.TEMPAT_LAHIR,
            DatabaseContract.AlumniColumns.TANGGAL_LAHIR,
            DatabaseContract.AlumniColumns.ALAMAT,
            DatabaseContract.AlumniColumns.AGAMA,
            DatabaseContract.AlumniColumns.NOMOR_HP,
            DatabaseContract.AlumniColumns.TAHUN_MASUK,
            DatabaseContract.AlumniColumns.TAHUN_LULUS,
            DatabaseContract.AlumniColumns.PEKERJAAN,
            DatabaseContract.AlumniColumns.JABATAN
    );

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_ALUMNI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(db);
    }
}
