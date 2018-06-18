package com.example.android.newsappabnd;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    private String mUrl;

    public NewsLoader(Context context, String mUrl) {
        super(context);
        this.mUrl = mUrl;
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<News> articles = JsonQuery.fetchNews(mUrl);
        return articles;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
