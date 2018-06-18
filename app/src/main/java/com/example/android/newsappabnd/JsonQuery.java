package com.example.android.newsappabnd;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class JsonQuery {
    Context context;

    private JsonQuery() {
    }

    public static List<News> fetchNews(String jsonSourceURL) {

        URL url = createUrl(jsonSourceURL);
        String jsonRequestResult = null;
        try {
            jsonRequestResult = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e("JSON query utils", "Problem making the HTTP request.", e);
        }
        List<News> articles = extractFeatureFromJson(jsonRequestResult);
        return articles;
    }

    public static List<News> extractFeatureFromJson(String jsonRequestResult) {
        List<News> articles = new ArrayList<>();
        try {
            JSONObject rootJsonResponse = new JSONObject(jsonRequestResult);
            JSONObject responseJSONObject = rootJsonResponse.getJSONObject("response");
            JSONArray resultsJSONArray = responseJSONObject.getJSONArray("results");
            for (int i = 0; i < resultsJSONArray.length(); i++) {
                JSONObject currentArticle = resultsJSONArray.getJSONObject(i);
                String webPublDate = currentArticle.getString("webPublicationDate");
                String title = currentArticle.getString("webTitle");
                String section = currentArticle.getString("sectionName");
                String articleUrl = currentArticle.getString("webUrl");
                JSONObject fields = currentArticle.getJSONObject("fields");
                String author = fields.getString("byline");

                News article = new News(webPublDate, title, section, articleUrl, author);

                articles.add(article);
            }

        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return articles;
    }


    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("JsonQuery", "createUrl method exception", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonRequestResult = "";

        if (url == null) {
            return jsonRequestResult;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonRequestResult = readFromStream(inputStream);
            } else {
                Log.e("JsonQuery", "HttpRequest error: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("JsonQuery", "makeHttpRequest exception", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonRequestResult;
    }
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }


}
