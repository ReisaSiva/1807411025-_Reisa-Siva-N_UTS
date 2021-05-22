package pnj.uts.ti.reisasiva.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pnj.uts.ti.reisasiva.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FIELD_TIDAK_VAlID = "Email tidak valid";
    public static final String FIELD_REQUIRED = "Field tidak boleh kosong";

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setTitle("Sign In");

        editTextEmail = findViewById(R.id.editTextUserEmail);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        preferences = getSharedPreferences("uts", MODE_PRIVATE);

        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonLogin) {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (email.equals("rei@gmail.com") && password.equals("rei123")) {
                saveToSharedPreference();
                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                startActivity(intent);
            } else if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
                editTextEmail.setError(FIELD_REQUIRED);
            } else if (TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
                editTextPassword.setError(FIELD_REQUIRED);
            } else if (!isValidEmail(email)) {
                editTextEmail.setError(FIELD_TIDAK_VAlID);
            } else {
                Toast.makeText(SignInActivity.this, "Email & Password Salah", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void saveToSharedPreference() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", "rei@gmail.com");
        editor.putString("password", "rei123");
        editor.putString("nim", "1807411025");
        editor.putString("nama", "Reisa Siva Nandika");
        editor.putString("kelas", "TI-6-Reguler");
        editor.putBoolean("isLogin", true);
        editor.apply();
    }

    private boolean isValidEmail(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}