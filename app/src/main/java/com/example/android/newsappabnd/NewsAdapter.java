package com.example.android.newsappabnd;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NewsAdapter extends ArrayAdapter {

    public NewsAdapter(Context context, List<News> articles){
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
        String title = currentArticle.getTitle();
        String author = currentArticle.getAuthor();
        titleView.setText(title + " - " + author );

        TextView dateView = (TextView) convertView.findViewById(R.id.date_view);
        String date = currentArticle.getWebPublDate();
        String displayDate = null;
        try {
            displayDate = formatDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateView.setText(displayDate);

        return convertView;
    }

    private String formatDate(String date) throws ParseException {
        SimpleDateFormat parsedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String displayDate = new SimpleDateFormat("dd-MM-yyyy").format(parsedDate);
        return displayDate;
    }

}
