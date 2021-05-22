package pnj.uts.ti.reisasiva.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import pnj.uts.ti.reisasiva.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("uts", MODE_PRIVATE);
        if (preferences.getBoolean("isLogin", false)) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
            finish();
        }
    }
}