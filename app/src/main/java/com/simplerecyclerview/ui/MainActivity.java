package com.simplerecyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.simplerecyclerview.R;
import com.simplerecyclerview.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 12.06.15.
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFilms;
    private FilmsAdapter filmsAdapter;

    private List<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFilms();
        initRecyclerView();
    }

    private void initRecyclerView() {
        rvFilms = (RecyclerView) findViewById(R.id.rv_films);
        rvFilms.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvFilms.setItemAnimator(new DefaultItemAnimator());
        filmsAdapter = new FilmsAdapter(films);
        rvFilms.setAdapter(filmsAdapter);

        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                films.remove(viewHolder.getAdapterPosition());
                filmsAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        swipeToDismissTouchHelper.attachToRecyclerView(rvFilms);
    }

    private List<Film> initFilms() {
        films = new ArrayList<>();
        films.add(new Film("The Transporter 1", "25.06.15"));
        films.add(new Film("The Transporter 2", "27.07.15"));
        films.add(new Film("The Transporter 3", "31.08.15"));
        return films;
    }

    public void addFilm(View view) {
        films.add(0, new Film("The Transporter 4", "15.09.15"));
        filmsAdapter.notifyItemInserted(0);
        rvFilms.scrollToPosition(0);
    }

    public void deleteFilm(View view) {
        if(!films.isEmpty()){
            films.remove(0);
            filmsAdapter.notifyItemRemoved(0);
        }else {
            Toast.makeText(getApplicationContext(),"List is empty", Toast.LENGTH_LONG).show();
        }
    }
}
