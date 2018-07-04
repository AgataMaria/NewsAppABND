package com.example.android.newsappabnd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class NewsAdapter extends ArrayAdapter<News> {

    private static final String TITLE_SEPARATOR = "\\|";


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

        String authorRaw = currentArticle.getAuthor();
        String author;
        if (authorRaw.equals("Letters")) {
            authorRaw.trim();
            titleView.setText(title);
        } else {
            author = authorRaw;
        titleView.setText(title + " - " + author);}

        TextView dateView = (TextView) convertView.findViewById(R.id.date_view);
        String dateRaw = currentArticle.getWebPublDate();
        String date = formatDate(dateRaw);
        dateView.setText("date published: " + date);

        return convertView;
    }

    private String formatDate(String dateObject) {
        String displayDate = "";
        SimpleDateFormat inputDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        SimpleDateFormat outputDate = new SimpleDateFormat("HH:mm, dd.MM.yyyy", Locale.getDefault());
        try {
            Date newDate = inputDate.parse(dateObject);
            return outputDate.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return displayDate;
    }
}

