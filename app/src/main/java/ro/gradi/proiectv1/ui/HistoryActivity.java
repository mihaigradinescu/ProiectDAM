package ro.gradi.proiectv1.ui;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import ro.gradi.proiectv1.R;
import ro.gradi.proiectv1.db.PubReview;
import ro.gradi.proiectv1.db.PubsDatabase;

public class HistoryActivity extends Activity {
    private RecyclerView bList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<PubReview> pubReviewList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        bList = findViewById(R.id.history_list);

        pubReviewList = new ArrayList<>();
        adapter = new HistoryAdapter(getApplicationContext(), pubReviewList, null);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());

        bList.setHasFixedSize(true);
        bList.setLayoutManager(linearLayoutManager);
        bList.addItemDecoration(dividerItemDecoration);
        bList.setAdapter(adapter);

        getHistory();
    }

    private void getHistory() {

        pubReviewList.clear();
        pubReviewList.addAll(PubsDatabase.getDatabase(this).reviewsDao().getAllPubReviews());
        adapter.notifyDataSetChanged();

    }
}
