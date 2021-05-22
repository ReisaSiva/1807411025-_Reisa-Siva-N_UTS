package pnj.uts.ti.reisasiva.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pnj.uts.ti.reisasiva.R;
import com.squareup.picasso.Picasso;

public class DetailBeritaActivity extends AppCompatActivity {

    ImageView imageViewDetailBeritaImage;
    TextView textViewDetailBeritaJudul, textViewDetailBeritaDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        setTitle("Detail Berita");

        imageViewDetailBeritaImage = findViewById(R.id.imageViewDetailBeritaImage);
        textViewDetailBeritaJudul = findViewById(R.id.textViewDetailBeritaJudul);
        textViewDetailBeritaDeskripsi = findViewById(R.id.textViewDetailBeritaDeskripsi);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Picasso.get().load(extras.getString("image", "")).into(imageViewDetailBeritaImage);
            textViewDetailBeritaJudul.setText(extras.getString("judul", ""));
            textViewDetailBeritaDeskripsi.setText(extras.getString("deskripsi", ""));
        }
    }
}