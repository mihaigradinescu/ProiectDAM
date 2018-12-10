package ro.gradi.bere;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ro.gradi.proiectv1.R;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.ViewHolder> {
    private Context context;
    private List<BarsAroundCSIE> list;


    public BeerAdapter(Context context, List<BarsAroundCSIE> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position){
        BarsAroundCSIE bar = list.get(position);

        holder.textName.setText(bar.getName());
        holder.textRating.setRating((float) bar.getRating());
        holder.textVicinity.setText(bar.getVicinity());
        Picasso.get().setLoggingEnabled(true);
        Picasso.get()
                .load(bar.getPhotoURL())
                .placeholder(android.R.drawable.sym_def_app_icon)
                .fit()
                .into(holder.imageIcon);

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageIcon;
        public TextView textName, textVicinity;
        public RatingBar textRating;

        public ViewHolder(View itemView){
            super(itemView);

            textName = itemView.findViewById(R.id.main_name);
            textRating = itemView.findViewById(R.id.main_rating);
            textVicinity = itemView.findViewById(R.id.main_vicinity);
            imageIcon = itemView.findViewById(R.id.main_icon);
        }
    }
}
