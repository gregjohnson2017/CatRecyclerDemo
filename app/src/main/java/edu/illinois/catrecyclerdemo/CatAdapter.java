package edu.illinois.catrecyclerdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.attr.start;

/**
 * Created by zilles on 10/31/17.
 */

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    public static final String IMG_URL = "img-url";
    private List<Cat> cats = new ArrayList<>();

    public CatAdapter(Cat[] cats) {
        this.cats.addAll(Arrays.asList(cats));
    }

    public void addCat(Cat cat) {
        cats.add(0, cat);
    }

    @Override
    public int getItemViewType(int position) {
        Cat cat = cats.get(position);
        return (cat.getImageUrl() != null) ? R.layout.cat_with_image : R.layout.cat;
        // return R.layout.cat_with_image;      // if you want to hard-code the ViewType
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View catItem = LayoutInflater.from(parent.getContext()).
                inflate(viewType, parent, false);

        return new ViewHolder(catItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Cat cat = cats.get(position);
        holder.nameTextView.setText(cat.getName());
        final String location = cat.getLocation();
        holder.locationButton.setText(location);
        try {
            // URL encoding.  See: https://en.wikipedia.org/wiki/Percent-encoding
            final String encodedLocation = URLEncoder.encode(location, "UTF-8");
            holder.locationButton.setEnabled(true);

            holder.locationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Context context = v.getContext();

                    // generate a geo-location URI using the URL encoded city, state information
                    Uri locationUri = Uri.parse("geo:0,0?q=" + encodedLocation);

                    // Launch an implicit intent to map that location.
                    Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            });
        } catch (Exception e) {
            // disable the button, so users don't think they can click here.  Also, remove any
            // on click listener from recycling this View
            holder.locationButton.setEnabled(false);
            holder.locationButton.setOnClickListener(null);
        }

        final String imageUrl = cat.getImageUrl();
        if (imageUrl != null) {
            final Context context = holder.itemView.getContext();
            Picasso.with(context).load(imageUrl).into(holder.imageView);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Context context = v.getContext();
                    Intent detailedIntent = new Intent(context, DetailActivity.class);

                    // rather than passing individual values, pass the whole cat (as a Parcelable)
//                    detailedIntent.putExtra(IMG_URL, imageUrl);
                    detailedIntent.putExtra("cat", cat);

                    context.startActivity(detailedIntent);
                }
            });
        } else {
            // we don't want a recycled on click listener to still be attached
            holder.itemView.setOnClickListener(null);
        }


    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView nameTextView;
        public Button locationButton;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            this.locationButton = (Button) itemView.findViewById(R.id.locationTextView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
