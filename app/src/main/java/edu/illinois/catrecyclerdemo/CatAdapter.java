package edu.illinois.catrecyclerdemo;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zilles on 10/31/17.
 */

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
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
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View catItem = LayoutInflater.from(parent.getContext()).
                inflate(viewType, parent, false);

        return new ViewHolder(catItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cat cat = cats.get(position);
        holder.nameTextView.setText(cat.getName());
        holder.locationTextView.setText(cat.getLocation());
        if (cat.getImageUrl() != null) {
            final Context context = holder.itemView.getContext();
            Picasso.with(context).load(cat.getImageUrl()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView nameTextView;
        public TextView locationTextView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            this.locationTextView = (TextView) itemView.findViewById(R.id.locationTextView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
