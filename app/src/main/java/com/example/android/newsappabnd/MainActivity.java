package com.example.android.newsappabnd;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<News>> {

    private NewsAdapter myNewsAdapter;
    private TextView mEmptyStateTextView;
    private static final String JSON_SOURCE_URL = "https://content.guardianapis.com/search?from-date=2018-05-01&q=culture%2Ffilm%2Fmusic%2Ftv-and-radio%2Fbooks%2Fstage&show-fields=byline&api-key=99080e73-4028-4414-97b6-7f2d47fa5cdd";
    private static final int NEWS_LOADER_ID = 0;
    private ListPreference mListPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create a ListView to be populated by a list of News articles
        // or an empty state view
        // or a loading list progress view
        // and defines the layout file to use

        ListView newsListView = (ListView) findViewById(R.id.news_list);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_text_view);
        newsListView.setEmptyView(mEmptyStateTextView);

        // create and set an adapter on the ListView to handle populating it with clickable News items
        myNewsAdapter = new NewsAdapter(this, new ArrayList<News>());
        newsListView.setAdapter(myNewsAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News selectedArticle = (News) myNewsAdapter.getItem(position);
                Uri selectedArticleUri = Uri.parse(selectedArticle.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, selectedArticleUri);
                startActivity(websiteIntent);
            }
        });

        //use the ConnectivityManager class to check the network connection and decide app behaviour
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            // if ConnectivityManager confirms network connection - initiate Loader
            LoaderManager loaderManager = getLoaderManager();

            loaderManager.initLoader(NEWS_LOADER_ID, null, this);

            // if there is no network connection = hide the progress bar and
            // display the empty state view
        } else {

            View progressBarView = findViewById(R.id.progress_bar);
            progressBarView.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }
    //Menu methods
    // inflate menu layout (to use to get to the app settings activity)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings_choice) {
            Intent settingsIntent = new Intent(this, AppSettings.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // override methods required by the news Loader
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
String selectedSection = sharedPreferences.getString(getString(R.string.settings_section_choice_key), getString(R.string.settings_section_choice_default));

        Uri baseUri = Uri.parse(JSON_SOURCE_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        if (!selectedSection.equals(getString(R.string.settings_section_choice_default))) {
            uriBuilder.appendQueryParameter("section", selectedSection);
        }
            return new NewsLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> articles) {
        myNewsAdapter.clear();

        View progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        mEmptyStateTextView.setText(R.string.no_news);

        if (articles != null && !articles.isEmpty()) {
            myNewsAdapter.addAll(articles);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        myNewsAdapter.clear();
    }
}

