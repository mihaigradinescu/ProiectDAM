package ro.gradi.proiectv1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ro.gradi.bere.BarsAroundCSIE;
import ro.gradi.bere.BeerAdapter;

public class HaveABeerInsteadActivity extends Activity {

    private RecyclerView bList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<BarsAroundCSIE> barsList;
    private RecyclerView.Adapter adapter;

    private String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=44.4479819,26.0990349&radius=500&types=bar&key=AIzaSyAKF6THWkkiH1P-AahUj1auh-Z4A7xQ0dA";

    private String urlPoza = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=%s&key=AIzaSyAKF6THWkkiH1P-AahUj1auh-Z4A7xQ0dA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_abeer_instead);

        bList = findViewById(R.id.main_list);

        barsList = new ArrayList<>();
        adapter = new BeerAdapter(getApplicationContext(), barsList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(bList.getContext(), linearLayoutManager.getOrientation());

        bList.setHasFixedSize(true);
        bList.setLayoutManager(linearLayoutManager);
        bList.addItemDecoration(dividerItemDecoration);
        bList.setAdapter(adapter);

        getData();
    }

    private void getData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Listener<JSONObject>() {
            @Override
            public void onResponse (JSONObject response){
                try {
                    JSONArray results = response.getJSONArray("results");
                    for( int i=0; i< results.length(); i++){
                        JSONObject jsonObjectBar = results.getJSONObject(i);

                        BarsAroundCSIE bar = new BarsAroundCSIE();
                        bar.setName(jsonObjectBar.getString("name"));
                        bar.setRating(jsonObjectBar.getDouble("rating"));
                        bar.setVicinity(jsonObjectBar.getString("vicinity"));
                        bar.setPhotoURL(jsonObjectBar.getString("icon"));

                        try {
                            JSONArray photos = jsonObjectBar.getJSONArray("photos");

                            if (photos.length() > 0){
                                JSONObject primaPoza = photos.getJSONObject(0);

                                bar.setPhotoURL(
                                        String.format(urlPoza,
                                                primaPoza.getString("photo_reference")));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        barsList.add(bar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
