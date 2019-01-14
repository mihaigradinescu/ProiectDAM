package ro.gradi.proiectv1.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import ro.gradi.proiectv1.PubsApplication;
import ro.gradi.proiectv1.R;

public class Quiz3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
    }

    public void goToQuiz4(View view) {

        Switch visited = this.findViewById(R.id.quiz3Switch1);

        PubsApplication app = (PubsApplication)getApplicationContext();
        app.setVisited(visited.isChecked());

        Intent intent = new Intent(this, Quiz4Activity.class);
        startActivity(intent);
    }
}
