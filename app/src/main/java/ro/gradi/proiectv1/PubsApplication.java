package ro.gradi.proiectv1;

import android.app.Application;

import java.util.Calendar;

import ro.gradi.proiectv1.db.BarsAroundCSIE;

public class PubsApplication extends Application {
    private BarsAroundCSIE currentBar;
    private Calendar date;
    private boolean visited;
    private int choice;


    public BarsAroundCSIE getCurrentBar() {
        return currentBar;
    }

    public void setCurrentBar(BarsAroundCSIE currentBar) {
        this.currentBar = currentBar;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
