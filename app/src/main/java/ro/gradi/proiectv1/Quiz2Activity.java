package ro.gradi.proiectv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Quiz2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
    }
    public void goToQuiz3(View view) {
        Intent intent = new Intent(this, Quiz3Activity.class);
        startActivity(intent);
    }
}
