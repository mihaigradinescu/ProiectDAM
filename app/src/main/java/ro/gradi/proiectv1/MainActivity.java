package ro.gradi.proiectv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText loginUsernameET;
    private EditText loginPasswordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            Intent intent = new Intent(this, MyProfileActivity.class);
            intent.putExtra("EXTRA_USERNAME", loginUsernameET.getText().toString());
            startActivity(intent);
        }
    }
}
