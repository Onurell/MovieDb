package com.moviedb;

import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

//public class MoveList {
//}

public class MoveList extends AsyncTask<String,String,String>
{
    private String JSON_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key=800d9d31f1b0a9dc6b9ba8507e20fc86";
    private List<ModelClass> movieList = null;
    Context _context=null;
    RecyclerView _rView = null;

    public MoveList(Context context, RecyclerView rView){
        _context = context;
        _rView = rView;
        movieList = new ArrayList<>();
    }

    @Override
    protected String doInBackground(String... strings) {

        String current = "";

        try{
            URL url;
            HttpURLConnection urlConnection = null;

            try{
                url = new URL(JSON_URL);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream is = urlConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                int data = isr.read();

                while (data != -1)
                {
                    current += (char) data;
                    data = isr.read();
                }

                return current;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(urlConnection != null)
                    urlConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return current;
    }

    @Override
    protected void onPostExecute(String s) {


        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for(int i = 0;i < jsonArray.length(); i++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                ModelClass model = new ModelClass();

                model.setTitle(jsonObject1.getString("title"));
                model.setId(jsonObject1.getString("release_date"));
                model.setPoster_path(jsonObject1.getString("poster_path"));

                movieList.add(model);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        PutDataIntoRecyclerView(movieList);
        super.onPostExecute(s);
    }

    private void PutDataIntoRecyclerView(List<ModelClass> movieList)
    {
        MoveListRecViewAdaptor moveListRecViewAdaptor = new MoveListRecViewAdaptor(_context,movieList);
        _rView.setLayoutManager(new LinearLayoutManager(_context));

        _rView.setAdapter(moveListRecViewAdaptor);



    }
}

