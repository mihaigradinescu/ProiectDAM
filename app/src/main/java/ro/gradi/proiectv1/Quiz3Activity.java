package ro.gradi.proiectv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Quiz3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
    }

    public void goToQuiz4(View view) {
        Intent intent = new Intent(this, Quiz4Activity.class);
        startActivity(intent);
    }
}
