package com.moviedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.moviedb.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = findViewById(R.id.imageSlider);
        recyclerView = findViewById(R.id.recyclerView);
        new MoveList(this,recyclerView).execute();

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://www.themoviedb.org/t/p/w300_and_h450_bestv2/RcKEvUiG8DafP8ej39ofLuLg1d.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.themoviedb.org/t/p/w300_and_h450_bestv2/LQodiqLLJc8N19HUJZ8DMMkfpe.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.themoviedb.org/t/p/w300_and_h450_bestv2/sk8FcOocDVzHNeinLwDV4784n72.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.themoviedb.org/t/p/w300_and_h450_bestv2/2sTwVe3xBIWkbRUktYbDB8MdDN7.jpg", ScaleTypes.FIT));


       imageSlider.setImageList(slideModels,ScaleTypes.FIT);


    }



}