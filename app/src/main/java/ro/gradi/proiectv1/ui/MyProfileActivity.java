package ro.gradi.proiectv1.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ro.gradi.proiectv1.R;
import ro.gradi.proiectv1.utils.PrefsUtils;

public class MyProfileActivity extends Activity {

    private TextView myprofileHelloET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        myprofileHelloET = findViewById(R.id.myprofileHelloET);

        String username= getIntent().getStringExtra("EXTRA_USERNAME");
        if (username == null) {
            username = PrefsUtils.readUsername(this);
        }

        PrefsUtils.saveUsername(this, username);
        myprofileHelloET.setText("Salut " + username);

        ImageView avatar = findViewById(R.id.imageView3);
        Picasso.get()
                .load(R.drawable.ic_child_care)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .fit()
                .into(avatar);

    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, Quiz1Activity.class);
        startActivity(intent);
    }

    public void goToHaveBeer(View view){
        Intent intent = new Intent(this, HaveABeerInsteadActivity.class);
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

    public void onLogout(View view) {
        PrefsUtils.saveUsername(this, null);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void openHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}
