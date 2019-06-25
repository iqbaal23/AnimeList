package com.example.animelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView photo;
    TextView name, remarks, sinopsis, date, studio, genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_anime);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        photo = (ImageView) findViewById(R.id.img_item_photo);
        name = (TextView) findViewById(R.id.tv_item_name);
        remarks = (TextView) findViewById(R.id.tv_item_remarks);
        sinopsis = (TextView) findViewById(R.id.tv_sinopsis);
        date = (TextView) findViewById(R.id.tv_date);
        studio = (TextView) findViewById(R.id.tv_studio);
        genre = (TextView) findViewById(R.id.tv_genre);

        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getExtras().getString("Name"));
        name.setText(intent.getExtras().getString("Name"));
        remarks.setText("Rating "+intent.getExtras().getString("Remarks"));
        sinopsis.setText(intent.getExtras().getString("Sinopsis"));
        date.setText(intent.getExtras().getString("Date"));
        studio.setText(intent.getExtras().getString("Studio"));
        genre.setText(intent.getExtras().getString("Genre"));

        Glide.with(this)
                .load(intent.getExtras().getString("Photo"))
                .into(photo);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
