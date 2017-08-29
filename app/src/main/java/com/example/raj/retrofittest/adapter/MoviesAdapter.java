package com.example.raj.retrofittest.adapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.example.raj.retrofittest.R;
import com.example.raj.retrofittest.model.Movie;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by raj on 8/19/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView date;
        TextView movieDescription;
        TextView rating;
        CardView cardView;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            date = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public void showPopup(View view) {
        View popupView = LayoutInflater.from(context).inflate(R.layout.description_popup, null);

        // Blah Blah remaining stuff...
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.date.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, holder.movieDescription.getText().toString(), Toast.LENGTH_LONG).show();

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.description_popup);
                dialog.setTitle("Title...");
                TextView title = (TextView) dialog.findViewById(R.id.popup_title);
                title.setText(movies.get(position).getTitle());
                title.setTypeface(null, Typeface.BOLD);
                title.setBackgroundColor(Color.BLUE);
                title.setTextColor(Color.WHITE);
                TextView desc = (TextView) dialog.findViewById(R.id.desc);
                desc.setText(holder.movieDescription.getText().toString());
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
