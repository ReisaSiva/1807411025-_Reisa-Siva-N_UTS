package pnj.uts.ti.reisasiva.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import pnj.uts.ti.reisasiva.R;
import pnj.uts.ti.reisasiva.ui.fragments.BeritaFragment;
import pnj.uts.ti.reisasiva.ui.fragments.HomeFragment;
import pnj.uts.ti.reisasiva.ui.fragments.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    HomeFragment homeFragment = new HomeFragment();
    BeritaFragment beritaFragment = new BeritaFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferences = getSharedPreferences("uts", MODE_PRIVATE);
        setTitle(preferences.getString("nama", ""));

        bottomNavigation = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, homeFragment).commit();

        bottomNavigation.setOnNavigationItemSelectedListener(navigationListener);
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener navigationListener = item -> {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.menu_home:
                selectedFragment = homeFragment;
                item.setChecked(true);
                break;
            case R.id.menu_berita:
                selectedFragment = beritaFragment;
                item.setChecked(true);
                break;
            case R.id.menu_profile:
                selectedFragment = profileFragment;
                item.setChecked(true);
                break;
        }
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
        }
        return false;
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.side_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_tambah_data:
                Intent tambahDataIntent = new Intent(HomeActivity.this, TambahDataAlumniActivity.class);
                startActivity(tambahDataIntent);
                break;
            case R.id.menu_data_alumni:
                Intent dataAlumniIntent = new Intent(HomeActivity.this, DataAlumniActivity.class);
                startActivity(dataAlumniIntent);
                break;
            case R.id.menu_logout:
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent logoutIntent = new Intent(HomeActivity.this, SignInActivity.class);
                startActivity(logoutIntent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}