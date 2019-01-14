package ro.gradi.proiectv1.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ro.gradi.proiectv1.R;
import ro.gradi.proiectv1.db.PubReview;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private final View.OnClickListener listener;
    private Context context;
    private List<PubReview> list;

    public HistoryAdapter(Context context, List<PubReview> list, View.OnClickListener listener) {
        this.listener = listener;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.history_item, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v);
                }
            }
        });
        return new HistoryAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        PubReview review = list.get(position);

        holder.barName.setText(review.getPubName());

        Date date = new Date(review.getTimestamp());
        DateFormat df = new SimpleDateFormat("EEE, MMM d, ''yy", Locale.getDefault());
        holder.dateVisited.setText(df.format(date));
        String message = review.getRecOption() == 0 ?
                "Nu as mai calca niciodata aici" :
                (review.getRecOption() == 1 ?
                        "Merita vizitat o data" :
                        "As merge aici zilnic");
        holder.choice.setText(message);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView barName;
        public TextView dateVisited;
        public TextView choice;

        public ViewHolder(View itemView){
            super(itemView);

            barName = itemView.findViewById(R.id.h_name);
            dateVisited = itemView.findViewById(R.id.h_date_visited);
            choice = itemView.findViewById(R.id.h_choice);
        }
    }
}
