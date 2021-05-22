package pnj.uts.ti.reisasiva.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import pnj.uts.ti.reisasiva.R;
import pnj.uts.ti.reisasiva.R;
import pnj.uts.ti.reisasiva.model.Alumni;

import java.util.ArrayList;

public class AlumniListViewAdapter extends ArrayAdapter<Alumni> {

    private final Context context;
    int resource;
    private ArrayList<Alumni> alumnis = new ArrayList<>();

    public void setAlumnis(ArrayList<Alumni> alumnis) {
        this.alumnis = alumnis;
    }

    public AlumniListViewAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, viewGroup, false);
            holder.textViewAlumniNIM = view.findViewById(R.id.textViewAlumniNIM);
            holder.textViewAlumniNama = view.findViewById(R.id.textViewAlumniNama);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        Alumni alumni = getItem(position);
        holder.textViewAlumniNIM.setText("NIM: " + alumni.getNim());
        holder.textViewAlumniNama.setText("Nama: " + alumni.getNama());

        return view;
    }

    class Holder {
        TextView textViewAlumniNIM, textViewAlumniNama;
    }
}
