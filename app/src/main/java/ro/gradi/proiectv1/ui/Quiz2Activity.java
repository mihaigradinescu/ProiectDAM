package ro.gradi.proiectv1.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ro.gradi.proiectv1.PubsApplication;
import ro.gradi.proiectv1.R;

public class Quiz2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
    }
    public void goToQuiz3(View view) {

        TimePicker timePicker = this.findViewById(R.id.quiz2OraQuizTP);

        PubsApplication app = (PubsApplication)getApplicationContext();

        Calendar calendar = app.getDate();

        calendar.set(Calendar.HOUR, timePicker.getHour());
        calendar.set(Calendar.MINUTE, timePicker.getMinute());

        app.setDate(calendar);

        Intent intent = new Intent(this, Quiz3Activity.class);
        startActivity(intent);
    }
}
