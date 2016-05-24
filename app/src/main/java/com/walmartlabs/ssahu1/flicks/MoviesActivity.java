package com.walmartlabs.ssahu1.flicks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);


        // Get movies we want to display


        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        AsyncHttpClient client = new AsyncHttpClient(true, 80, 443);
        RequestParams params = new RequestParams();
        client.get(url, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                // Get a reference to our ListView

                ListView lvMovies = (ListView) findViewById(R.id.lvMovies);

                ArrayList<Movie> movies;

                MovieResponse r = MovieResponse.parseJSON(response.toString());
                movies = r.getResults();

                // create arrayAdapter
                MoviesAdapter moviesAdapter = new MoviesAdapter(getApplicationContext(), movies);

                if (lvMovies != null) {
                    // Link adapter to our movies
                    lvMovies.setAdapter(moviesAdapter);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("error>>>>>>>>", "Failure on GET");
            }
        });
    }
}
