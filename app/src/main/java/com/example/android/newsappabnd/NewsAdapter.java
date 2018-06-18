package com.example.android.newsappabnd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class NewsAdapter extends ArrayAdapter<News> {

    private static final String TITLE_SEPARATOR = "\\|";
    private static final String DATE_SEPARATOR = "T";

    public NewsAdapter(Context context, List<News> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }
        News currentArticle = (News) getItem(position);

        TextView sectionView = (TextView) convertView.findViewById(R.id.section_view);
        sectionView.setText(currentArticle.getSection());

        TextView titleView = (TextView) convertView.findViewById(R.id.title_view);
        String titleRaw = currentArticle.getTitle();
        String title;
        if (titleRaw.contains(TITLE_SEPARATOR));
        String[] titleParts = titleRaw.split(TITLE_SEPARATOR);
        title = titleParts[0];
        String author = currentArticle.getAuthor();
        titleView.setText(title + " - " + author);

        TextView dateView = (TextView) convertView.findViewById(R.id.date_view);
        String dateRaw = currentArticle.getWebPublDate();
        String date;
        String[] dateParts = dateRaw.split(DATE_SEPARATOR);
        date = dateParts[0];
        dateView.setText(date);

        return convertView;
    }
}

