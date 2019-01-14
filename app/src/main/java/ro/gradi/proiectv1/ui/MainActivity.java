package ro.gradi.proiectv1.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ro.gradi.proiectv1.R;
import ro.gradi.proiectv1.utils.PrefsUtils;

public class MainActivity extends Activity {

    private EditText loginUsernameET;
    private EditText loginPasswordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String currentUser = PrefsUtils.readUsername(this);
        if (currentUser != null) {
            login(currentUser);
            return;
        }
        setContentView(R.layout.activity_main);

        loginUsernameET = findViewById(R.id.loginUsernameET);
        loginPasswordET = findViewById(R.id.loginPasswordET);
    }

    public void onRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void onLogin(View view) {
        if (loginUsernameET.getText().toString().isEmpty() || loginPasswordET.getText().toString().isEmpty()){
         // mesaj de eroare
            Toast.makeText(this, "Username & password required", Toast.LENGTH_LONG);
        }
        else {
            login(loginUsernameET.getText().toString());
        }
    }

    private void login(String username) {
        Intent intent = new Intent(this, MyProfileActivity.class);
        intent.putExtra("EXTRA_USERNAME", username);
        startActivity(intent);
    }
}
