package pnj.uts.ti.reisasiva.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import pnj.uts.ti.reisasiva.R;
import pnj.uts.ti.reisasiva.database.AlumniHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import pnj.uts.ti.reisasiva.database.DatabaseContract;

public class TambahDataAlumniActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextAlumniNIM, editTextAlumniNama, editTextAlumniTempatLahir, editTextAlumniTanggalLahir, editTextAlumniAlamat, editTextAlumniAgama, editTextAlumniNomorHp, editTextAlumniTahunMasuk, editTextAlumniTahunLulus, editTextAlumniPekerjaan, editTextAlumniJabatan;
    Button buttonSimpan;
    private AlumniHelper alumniHelper;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        setTitle("Tambah Data");

        editTextAlumniNIM = findViewById(R.id.editTextAlumniNIM);
        editTextAlumniNama = findViewById(R.id.editTextAlumniNama);
        editTextAlumniTempatLahir = findViewById(R.id.editTextAlumniTempatLahir);
        editTextAlumniTanggalLahir = findViewById(R.id.editTextAlumniTanggalLahir);
        editTextAlumniAlamat = findViewById(R.id.editTextAlumniAlamat);
        editTextAlumniAgama = findViewById(R.id.editTextAlumniAgama);
        editTextAlumniNomorHp = findViewById(R.id.editTextAlumniNomorHp);
        editTextAlumniTahunMasuk = findViewById(R.id.editTextAlumniTahunMasuk);
        editTextAlumniTahunLulus = findViewById(R.id.editTextAlumniTahunLulus);
        editTextAlumniPekerjaan = findViewById(R.id.editTextAlumniPekerjaan);
        editTextAlumniJabatan = findViewById(R.id.editTextAlumniJabatan);
        buttonSimpan = findViewById(R.id.buttonSimpan);

        buttonSimpan.setOnClickListener(this);
        editTextAlumniTanggalLahir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSimpan:
                String nim = editTextAlumniNIM.getText().toString().trim();
                String nama = editTextAlumniNama.getText().toString().trim();
                String tempatLahir = editTextAlumniTempatLahir.getText().toString().trim();
                String tanggalLahir = editTextAlumniTanggalLahir.getText().toString().trim();
                String alamat = editTextAlumniAlamat.getText().toString().trim();
                String agama = editTextAlumniAgama.getText().toString().trim();
                String nomorHp = editTextAlumniNomorHp.getText().toString().trim();
                String tahunMasuk = editTextAlumniTahunMasuk.getText().toString().trim();
                String tahunLulus = editTextAlumniTahunLulus.getText().toString().trim();
                String pekerjaan = editTextAlumniPekerjaan.getText().toString().trim();
                String jabatan = editTextAlumniJabatan.getText().toString().trim();

                alumniHelper = AlumniHelper.getInstance(getApplicationContext());
                alumniHelper.open();

                ContentValues values = new ContentValues();
                values.put(DatabaseContract.AlumniColumns.NIM, nim);
                values.put(DatabaseContract.AlumniColumns.NAMA, nama);
                values.put(DatabaseContract.AlumniColumns.TEMPAT_LAHIR, tempatLahir);
                values.put(DatabaseContract.AlumniColumns.TANGGAL_LAHIR, tanggalLahir);
                values.put(DatabaseContract.AlumniColumns.ALAMAT, alamat);
                values.put(DatabaseContract.AlumniColumns.AGAMA, agama);
                values.put(DatabaseContract.AlumniColumns.NOMOR_HP, nomorHp);
                values.put(DatabaseContract.AlumniColumns.TAHUN_MASUK, tahunMasuk);
                values.put(DatabaseContract.AlumniColumns.TAHUN_LULUS, tahunLulus);
                values.put(DatabaseContract.AlumniColumns.PEKERJAAN, pekerjaan);
                values.put(DatabaseContract.AlumniColumns.JABATAN, jabatan);

                long result = alumniHelper.insert(values);

                if (result != -1) {
                    Toast.makeText(this, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Data gagal ditambah", Toast.LENGTH_SHORT).show();
                }

                alumniHelper.close();
                break;
            case R.id.editTextAlumniTanggalLahir:
                new DatePickerDialog(this, dateSetListener, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            editTextAlumniTanggalLahir.setText(dateFormat.format(calendar.getTime()));

        }
    };
}