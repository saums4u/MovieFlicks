package com.walmartlabs.ssahu1.flicks;

import java.util.List;

/**
 * Created by ssahu6 on 5/17/16.
 */
public class Movie {
    public String poster_path;

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public Boolean adult;
    public String overview;
    public String release_date;
    public List<Integer> genre_ids;
    public Integer id;
    public String original_title;
    public String original_language;
    public String title;

    public String backdrop_path;
    public Double popularity;
    public Integer vote_count;
    public Boolean video;
    public Double vote_average;

    public Boolean getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }


    public Integer getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public Double getPopularity() {
        return popularity;
    }


    public Boolean getVideo() {
        return video;
    }

}
