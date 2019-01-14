package ro.gradi.proiectv1.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ro.gradi.proiectv1.PubsApplication;
import ro.gradi.proiectv1.R;

public class Quiz1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
    }

    public void goToQuiz2(View view) {
        DatePicker datePicker = this.findViewById(R.id.quiz1DataNasteriiDP);

        Calendar calendar = new GregorianCalendar();

        calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
        calendar.set(Calendar.MONTH, datePicker.getMonth());
        calendar.set(Calendar.YEAR, datePicker.getYear());

        PubsApplication app = (PubsApplication)getApplicationContext();
        app.setDate(calendar);

        Intent intent = new Intent(this, Quiz2Activity.class);
        startActivity(intent);
    }
}
