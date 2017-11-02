package edu.illinois.catrecyclerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static edu.illinois.catrecyclerdemo.R.id.imageView;
import static edu.illinois.catrecyclerdemo.R.layout.cat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get a cat out of extras passed with intent
        final Intent intent = getIntent();
        Cat cat = intent.getParcelableExtra("cat");
        final String imgUrl = cat.getImageUrl();
//        final String imgUrl = intent.getStringExtra(CatAdapter.IMG_URL);

        // fill the image
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        final String imgUrl = "https://media.mnn.com/assets/images/2016/11/cat-with-big-eyes-gimo.jpg.653x0_q80_crop-smart.jpg";
        Picasso.with(this).load(imgUrl).into(imageView);

        // fill the name
        final TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(cat.getName());
    }
}
