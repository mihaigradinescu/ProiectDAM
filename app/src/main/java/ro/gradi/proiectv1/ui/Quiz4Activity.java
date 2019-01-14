package ro.gradi.proiectv1.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;
import java.util.Date;

import ro.gradi.proiectv1.PubsApplication;
import ro.gradi.proiectv1.R;
import ro.gradi.proiectv1.db.BarsAroundCSIE;
import ro.gradi.proiectv1.db.PubReview;
import ro.gradi.proiectv1.db.PubsDatabase;
import ro.gradi.proiectv1.utils.PrefsUtils;

public class Quiz4Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
    }

    public void goToProfile(View view) {

        PubsApplication app = (PubsApplication)getApplicationContext();

        RadioButton radioButton1 = findViewById(R.id.quiz4Varianta1RB);
        RadioButton radioButton2 = findViewById(R.id.quiz4Varianta2RB);
        RadioButton radioButton3 = findViewById(R.id.quiz4Varianta3RB);

        int option = radioButton1.isChecked() ? 0 : (radioButton2.isChecked() ? 1 : 2);
        app.setChoice(option);

        BarsAroundCSIE currentBar = app.getCurrentBar();
        Calendar date = app.getDate();

        PubReview pubReview = new PubReview(0, currentBar.getName(), date.getTimeInMillis(), app.isVisited(), app.getChoice());

        SaveReviewTask saveReviewTask = new SaveReviewTask(this, pubReview);
        saveReviewTask.execute();

    }

    private class SaveReviewTask extends AsyncTask<String, Void, String> {
        private final PubReview pubReview;

        public SaveReviewTask(Context context, PubReview pubReview) {
            this.pubReview = pubReview;
        }

        @Override
        protected String doInBackground(String... params) {
            PubsDatabase.getDatabase(Quiz4Activity.this).reviewsDao().insert(pubReview);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Intent intent = new Intent(Quiz4Activity.this, MyProfileActivity.class);
            startActivity(intent);
        }

        @Override
        protected void onPreExecute() {}
    }
}
