package ro.gradi.proiectv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Quiz1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
    }

    public void goToQuiz2(View view) {
        Intent intent = new Intent(this, Quiz2Activity.class);
        startActivity(intent);
    }
}
