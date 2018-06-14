package com.example.android.newsappabnd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter {

    public NewsAdapter(Context context, List<News> articles){
        super(context, 0, articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }
    News currentArticle = (News) getItem(position);

        TextView sectionView = (TextView) convertView.findViewById(R.id.section_view);
        sectionView.setText(currentArticle.getSection());

        TextView titleView = (TextView) convertView.findViewById(R.id.title_view);
        titleView.setText(currentArticle.getTitle());

        TextView dateView = (TextView) convertView.findViewById(R.id.date_view);
        dateView.setText(currentArticle.getWebPublDate());

    return convertView;}
}
