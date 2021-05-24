package com.example.movieinfo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieinfo.Model.Movie;
import com.example.movieinfo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

   private List<Movie> movies;
   private int rowLayout;
   private Context context;

    public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv,parent,false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        String image_url = IMAGE_URL_BASE_PATH + movies.get(position).getPosterPath();
        Picasso.with(context)
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .into(holder.movieImage);
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class  MovieViewHolder extends RecyclerView.ViewHolder{

        LinearLayout moviesLayout;
        TextView movieTitle,data,movieDescription,rating;
        ImageView movieImage;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            movieImage = (ImageView) itemView.findViewById(R.id.movie_image);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            data = (TextView) itemView.findViewById(R.id.date);
            movieDescription = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
