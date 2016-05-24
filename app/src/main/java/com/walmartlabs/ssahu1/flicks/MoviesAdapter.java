package com.walmartlabs.ssahu1.flicks;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ssahu6 on 5/17/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    // View lookup cache
    private static class ViewHolder {
        ImageView image;
        TextView title;
        TextView description;
    }


    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.activity_movies, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        Movie movie = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag


        String baseUrl = "http://image.tmdb.org/t/p/w342/";
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.ivPoster);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.description = (TextView) convertView.findViewById(R.id.tvDescription);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // set title
        viewHolder.title.setText(movie.getTitle());


        // set description.
        //viewHolder.description.setText(movie.getOverview().split("\\.")[0]);
        //viewHolder.description.setHeight(viewHolder.image.getHeight() - viewHolder.title.getHeight());
       // viewHolder.description.setHeight(viewHolder.image.getHeight());

        if(Configuration.ORIENTATION_LANDSCAPE == getContext().getResources().getConfiguration().orientation) {
            Log.d("MovieAdapter","landscape" );
            //load the image from url
            String imageUri = baseUrl+movie.getBackdrop_path();
            Log.d("MovieAdapter",imageUri);
            Picasso.with(getContext()).load(imageUri).into(viewHolder.image);
        } else {
            Log.d("MovieAdapter","portrait" );
            //load the image from url
            String imageUri = baseUrl+movie.getPoster_path();
            Log.d("MovieAdapter",imageUri);
            Picasso.with(getContext()).load(imageUri).into(viewHolder.image);
        }

        viewHolder.description.setText(movie.getOverview());
        Log.d("MoviesAdapter", "Row number:"+position);

        // Return the completed view to render on screen
        return convertView;
    }
}
