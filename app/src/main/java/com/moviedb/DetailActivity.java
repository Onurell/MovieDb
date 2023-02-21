package com.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.moviedb.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    private TextView baslik;
    private ImageView imageViewDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        baslik = findViewById(R.id.textView);
        imageViewDetail = findViewById(R.id.imageViewDetails);



        GetDataFromIntent();

     }

     private void GetDataFromIntent()
     {
         if(getIntent().hasExtra("movie"))
         {
             ModelClass moviemodel = null;
             if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                 moviemodel = getIntent().getSerializableExtra("movie", ModelClass.class);
             }

             baslik.setText(moviemodel.getTitle());

             Glide.with(this)
             .load("https://image.tmdb.org/t/p/w500"
             +moviemodel.getPoster_path())
                     .into(imageViewDetail);


         }
     }
}