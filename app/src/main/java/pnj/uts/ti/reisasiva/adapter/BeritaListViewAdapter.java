package pnj.uts.ti.reisasiva.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pnj.uts.ti.reisasiva.model.Berita;

import java.util.ArrayList;

import pnj.uts.ti.reisasiva.R;
import com.squareup.picasso.Picasso;

public class BeritaListViewAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Berita> news = new ArrayList<>();

    public void setNews(ArrayList<Berita> news) {
        this.news = news;
    }

    public BeritaListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        return news.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_berita, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Berita berita = (Berita) getItem(position);
        viewHolder.bind(berita);

        return itemView;
    }

    private static class ViewHolder {
        private final TextView judul, deskripsi;
        private final ImageView foto;

        ViewHolder(View view) {
            judul = view.findViewById(R.id.textViewJudulBerita);
            deskripsi = view.findViewById(R.id.textViewDeskripsiBerita);
            foto = view.findViewById(R.id.imageViewBeritaImage);
        }

        void bind(Berita berita) {
            judul.setText(berita.getJudul());
            deskripsi.setText(berita.getDeskripsi());
            Picasso.get().load(berita.getImage()).into(foto);
        }
    }
}
