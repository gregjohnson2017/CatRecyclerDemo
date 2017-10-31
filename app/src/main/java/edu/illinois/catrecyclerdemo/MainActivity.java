package edu.illinois.catrecyclerdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
        Cat[] cats = gson.fromJson(Cat.CATS_JSON, Cat[].class);
        final CatAdapter catAdapter = new CatAdapter(cats);

        final RecyclerView catList = (RecyclerView) findViewById(R.id.cat_list);
        catList.setAdapter(catAdapter);
        catList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Cat cat = new Cat("Joey", "Anchorage, AL", null);
                catAdapter.addCat(cat);
                catAdapter.notifyDataSetChanged();
            }
        }, 2000);
    }
}
