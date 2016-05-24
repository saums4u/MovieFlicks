package com.walmartlabs.ssahu1.flicks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * Created by ssahu6 on 5/23/16.
 */
public class MovieResponse {

    public Integer getPage() {
        return page;
    }

    public Integer page;

    public void setPage(Integer page) {
        this.page = page;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public ArrayList<Movie> results;

    public void setMovies(ArrayList<Movie> results) {
        this.results = results;
    }

    // public constructor is necessary for collections
    public MovieResponse() {
        results = new ArrayList<Movie>();
    }

    public static MovieResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        MovieResponse movieResponse = gson.fromJson(response, MovieResponse.class);
        return movieResponse;
    }

}
