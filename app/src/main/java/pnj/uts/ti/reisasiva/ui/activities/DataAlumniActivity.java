package pnj.uts.ti.reisasiva.ui.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import pnj.uts.ti.reisasiva.R;
import pnj.uts.ti.reisasiva.adapter.AlumniListViewAdapter;
import pnj.uts.ti.reisasiva.database.AlumniHelper;
import pnj.uts.ti.reisasiva.model.Alumni;

import java.util.ArrayList;

public class DataAlumniActivity extends AppCompatActivity {

    ListView listView;
    AlumniListViewAdapter alumniAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_alumni);
        setTitle("List Data Alumni");

        listView = findViewById(R.id.listViewAlumni);
        alumniAdapter = new AlumniListViewAdapter(this, R.layout.item_alumni);
        listView.setAdapter(alumniAdapter);

        getData();

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Alumni alumni = (Alumni) parent.getAdapter().getItem(position);

            Intent intent = new Intent(this, DetailDataAlumniActivity.class);
            intent.putExtra("nim", alumni.getNim());
            startActivity(intent);
        });
    }

    private void getData() {
        alumniAdapter.clear();
        ArrayList<Alumni> alumnis = new ArrayList<>();
        AlumniHelper alumniHelper = AlumniHelper.getInstance(getApplicationContext());
        alumniHelper.open();

        Cursor cursor = alumniHelper.queryAll();
        if (cursor.moveToFirst()) {
            do {
                Alumni alumni = new Alumni();
                alumni.setNim(cursor.getString(1));
                alumni.setNama(cursor.getString(2));
                alumnis.add(alumni);
            } while (cursor.moveToNext());
        }
        alumniAdapter.addAll(alumnis);
        alumniAdapter.notifyDataSetChanged();
        alumniHelper.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }
}