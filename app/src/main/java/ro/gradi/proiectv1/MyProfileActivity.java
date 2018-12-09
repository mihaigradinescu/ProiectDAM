package ro.gradi.proiectv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyProfileActivity extends Activity {

    private TextView myprofileHelloET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        myprofileHelloET = findViewById(R.id.myprofileHelloET);

        String helloUsername= getIntent().getStringExtra("EXTRA_USERNAME");

        myprofileHelloET.setText("Salut " + helloUsername);
    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, Quiz1Activity.class);
        startActivity(intent);
    }

    public void goToReview(View view) {
        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);
    }

    public void goToAbout(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void goToContact(View view) {
        Intent intent = new Intent(this, ContactMeActivity.class);
        startActivity(intent);
    }
}
