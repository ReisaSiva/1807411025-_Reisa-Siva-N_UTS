package pnj.uts.ti.reisasiva.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
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

public class DetailDataAlumniActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextDetailAlumniNIM, editTextDetailAlumniNama, editTextDetailAlumniTempatLahir, editTextDetailAlumniTanggalLahir, editTextDetailAlumniAlamat, editTextDetailAlumniAgama, editTextDetailAlumniNomorHp, editTextDetailAlumniTahunMasuk, editTextDetailAlumniTahunLulus, editTextDetailAlumniPekerjaan, editTextDetailAlumniJabatan;
    Button buttonUpdate, buttonDelete;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_alumni);
        setTitle("Detail Alumni");

        editTextDetailAlumniNIM = findViewById(R.id.editTextDetailAlumniNIM);
        editTextDetailAlumniNama = findViewById(R.id.editTextDetailAlumniNama);
        editTextDetailAlumniTempatLahir = findViewById(R.id.editTextDetailAlumniTempatLahir);
        editTextDetailAlumniTanggalLahir = findViewById(R.id.editTextDetailAlumniTanggalLahir);
        editTextDetailAlumniAlamat = findViewById(R.id.editTextDetailAlumniAlamat);
        editTextDetailAlumniAgama = findViewById(R.id.editTextDetailAlumniAgama);
        editTextDetailAlumniNomorHp = findViewById(R.id.editTextDetailAlumniNomorHp);
        editTextDetailAlumniTahunMasuk = findViewById(R.id.editTextDetailAlumniTahunMasuk);
        editTextDetailAlumniTahunLulus = findViewById(R.id.editTextDetailAlumniTahunLulus);
        editTextDetailAlumniPekerjaan = findViewById(R.id.editTextDetailAlumniPekerjaan);
        editTextDetailAlumniJabatan = findViewById(R.id.editTextDetailAlumniJabatan);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        editTextDetailAlumniNIM.setKeyListener(null);
        editTextDetailAlumniTanggalLahir.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        getData();
    }

    private void getData() {
        String nim = getIntent().getStringExtra("nim");
        AlumniHelper alumniHelper = AlumniHelper.getInstance(getApplicationContext());
        alumniHelper.open();
        Cursor cursor = alumniHelper.queryByNim(nim);
        cursor.moveToFirst();
        editTextDetailAlumniNIM.setText(cursor.getString(1));
        editTextDetailAlumniNama.setText(cursor.getString(2));
        editTextDetailAlumniTempatLahir.setText(cursor.getString(3));
        editTextDetailAlumniTanggalLahir.setText(cursor.getString(4));
        editTextDetailAlumniAlamat.setText(cursor.getString(5));
        editTextDetailAlumniAgama.setText(cursor.getString(6));
        editTextDetailAlumniNomorHp.setText(cursor.getString(7));
        editTextDetailAlumniTahunMasuk.setText(cursor.getString(8));
        editTextDetailAlumniTahunLulus.setText(cursor.getString(9));
        editTextDetailAlumniPekerjaan.setText(cursor.getString(10));
        editTextDetailAlumniJabatan.setText(cursor.getString(11));
        cursor.close();
        alumniHelper.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDelete:
                deleteAlumni();
                break;
            case R.id.buttonUpdate:
                updateAlumni();
                break;
            case R.id.editTextDetailAlumniTanggalLahir:
                new DatePickerDialog(this, dateSetListener, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }

    private void updateAlumni() {
        String nim = getIntent().getStringExtra("nim");
        AlumniHelper alumniHelper = AlumniHelper.getInstance(getApplicationContext());
        alumniHelper.open();
        ContentValues values = new ContentValues();

        values.put(DatabaseContract.AlumniColumns.NIM, editTextDetailAlumniNIM.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.NAMA, editTextDetailAlumniNama.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.TEMPAT_LAHIR, editTextDetailAlumniTempatLahir.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.TANGGAL_LAHIR, editTextDetailAlumniTanggalLahir.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.ALAMAT, editTextDetailAlumniAlamat.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.AGAMA, editTextDetailAlumniAgama.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.NOMOR_HP, editTextDetailAlumniNomorHp.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.TAHUN_MASUK, editTextDetailAlumniTahunMasuk.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.TAHUN_LULUS, editTextDetailAlumniTahunLulus.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.PEKERJAAN, editTextDetailAlumniPekerjaan.getText().toString().trim());
        values.put(DatabaseContract.AlumniColumns.JABATAN, editTextDetailAlumniJabatan.getText().toString().trim());

        long result = alumniHelper.update(nim, values);

        if (result != -1) {
            Toast.makeText(this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Data gagal diupdate", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteAlumni() {
        String nim = getIntent().getStringExtra("nim");
        AlumniHelper alumniHelper = AlumniHelper.getInstance(getApplicationContext());
        alumniHelper.open();
        alumniHelper.deleteByNim(nim);
        alumniHelper.close();
        Toast.makeText(this, "Alumni berhasil dihapus", Toast.LENGTH_SHORT).show();
        finish();
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            editTextDetailAlumniTanggalLahir.setText(dateFormat.format(calendar.getTime()));

        }
    };


}