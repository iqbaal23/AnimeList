package com.example.animelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView rvCategory;
    private ArrayList<Anime> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(AnimeData.getListData());
        showRecyclerList();
    }

    private void showSelectedAnime(Anime anime) {
//        Toast.makeText(this, "Kamu Memilih "+ anime.getName(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, DetailActivity.class);
        i.putExtra("Name", anime.getName());
        i.putExtra("Remarks", anime.getRemarks());
        i.putExtra("Photo", anime.getPhoto());
        i.putExtra("Sinopsis", anime.getSinposis());
        i.putExtra("Date", anime.getDate());
        i.putExtra("Studio", anime.getStudio());
        i.putExtra("Genre", anime.getGenre());
        startActivity(i);
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListAnimeAdapter listAnimeAdapter = new ListAnimeAdapter(this);
        listAnimeAdapter.setListAnime(list);
        rvCategory.setAdapter(listAnimeAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedAnime(list.get(position));
            }
        });
    }

}
