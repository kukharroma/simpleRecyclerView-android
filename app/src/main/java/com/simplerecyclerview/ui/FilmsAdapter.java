package com.simplerecyclerview.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.simplerecyclerview.R;
import com.simplerecyclerview.model.Film;

import java.util.List;

/**
 * Created by roma on 12.06.15.
 */
public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmViewHolder> {

    private List<Film> films;

    public FilmsAdapter(List<Film> films) {
        this.films = films;
    }

    @Override
    public FilmsAdapter.FilmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_film, viewGroup, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmsAdapter.FilmViewHolder viewHolder, int position) {
        viewHolder.tvFilmName.setText(films.get(position).getName());
        viewHolder.tvFilmDate.setText(films.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    static class FilmViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFilmIcon;
        TextView tvFilmName;
        TextView tvFilmDate;

        public FilmViewHolder(View itemView) {
            super(itemView);
            ivFilmIcon = (ImageView) itemView.findViewById(R.id.iv_film_icon);
            tvFilmName = (TextView) itemView.findViewById(R.id.tv_film_name);
            tvFilmDate = (TextView) itemView.findViewById(R.id.tv_film_date);
        }
    }
}
