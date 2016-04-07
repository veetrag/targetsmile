package com.targetsmile.dentalcare;

/**
 * Created by veetrag on 06/02/16.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static android.widget.ImageView.ScaleType.CENTER_CROP;


public class GridViewAdapter extends BaseAdapter {
        private final Context context;
        private final List<String> urls = new ArrayList<String>();

        public GridViewAdapter(Context context) {
            this.context = context;




            SharedPreferences prefs = context.getSharedPreferences("com.targetsmile.dentalcare", Context.MODE_PRIVATE);
            String[] linksArray;

            Set<String> stringLinkSet = prefs.getStringSet("linksToDentalFacts", new Data().fetchData());

            linksArray = stringLinkSet.toArray(new String[stringLinkSet.size()]);

            // Ensure we get a different ordering of images on each run.

            Collections.addAll(urls, linksArray);

            Collections.shuffle(urls);

        }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            SquaredImageView view = (SquaredImageView) convertView;
            if (view == null) {
                view = new SquaredImageView(context);
                view.setScaleType(CENTER_CROP);
            }

            // Get the image URL for the current position.
            String url = getItem(position);

            // Trigger the download of the URL asynchronously into the image view.
            Picasso.with(context) //
                    .load(url) //
                    .placeholder(R.drawable.placeholder) //
                    .fit() //
                    .tag(context) //
                    .into(view);

            return view;
        }

        @Override public int getCount() {
            return urls.size();
        }

        @Override public String getItem(int position) {
            return urls.get(position);
        }

        @Override public long getItemId(int position) {
            return position;
        }
    }
