package pnj.uts.ti.reisasiva.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import pnj.uts.ti.reisasiva.R;
import pnj.uts.ti.reisasiva.ui.activities.SignInActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    TextView textViewEmail, textViewNIM, textViewNama, textViewKelas;
    Button buttonLogout;
    SharedPreferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = getActivity().getSharedPreferences("uts", Context.MODE_PRIVATE);

        textViewEmail = view.findViewById(R.id.textViewProfileEmailValue);
        textViewNIM = view.findViewById(R.id.textViewProfileNIMValue);
        textViewNama = view.findViewById(R.id.textViewProfileNamaValue);
        textViewKelas = view.findViewById(R.id.textViewProfileKelasValue);
        buttonLogout = view.findViewById(R.id.buttonLogout);

        textViewEmail.setText(preferences.getString("email", ""));
        textViewNIM.setText(preferences.getString("nim", ""));
        textViewNama.setText(preferences.getString("nama", ""));
        textViewKelas.setText(preferences.getString("kelas", ""));

        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonLogout) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();

            Intent logoutIntent = new Intent(getActivity(), SignInActivity.class);
            startActivity(logoutIntent);
        }
    }
}