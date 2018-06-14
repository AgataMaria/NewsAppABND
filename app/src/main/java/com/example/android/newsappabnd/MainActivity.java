package com.example.android.newsappabnd;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity /*implements LoaderManager.LoaderCallbacks<List<News>>*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<News> articles = JsonQuery.extractFeatureFromJson();
            //private static final String JSON_REQUEST_URL =
            //       "https://content.guardianapis.com/search?api-key=test";

            // private static final int NEWS_LOADER_ID = 0;

            final NewsAdapter myAdapter;
            //TODO: display dla empty state
            // private TextView mEmptyStateTextView;

            ListView newsListView = (ListView) findViewById(R.id.list);

            //  mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
            //  earthquakeListView.setEmptyView(mEmptyStateTextView);

            myAdapter = new NewsAdapter(this, articles);
            newsListView.setAdapter(myAdapter);

            //TODO:on item click listener na ListView, znajdz url i utworz intent

            //   {
            //   @Override
            //   public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            //       News currentArticle = myAdapter.getItem(position);
            //Uri newsUri = Uri.parse(currenArticle.getUrl());
            //Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
            //startActivity(websiteIntent);
            //    }
            //});

            //TODO: sprawdz czy jest internet i jesli nie ma wyswietl komunikat
            /*ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

         if (networkInfo != null && networkInfo.isConnected()) {

            //TODO: zrob loader do ladowania tresci w tle
            LoaderManager loaderManager = getLoaderManager();

            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {

            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }*/

/*    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new EarthquakeLoader(this, JSON_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        mEmptyStateTextView.setText(R.string.no_news);
        myAdapter.clear();
        if (articles != null && !articles.isEmpty()) {
            myAdapter.addAll(articles);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        myAdapter.clear();
    }*/

        }
    }
