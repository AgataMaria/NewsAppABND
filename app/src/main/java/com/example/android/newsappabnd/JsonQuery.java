package com.example.android.newsappabnd;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class JsonQuery {
    Context context;
    private final String jsonSource = context.getString(R.string.temp_json);
    private JsonQuery() {
    }
        public static List<News> extractFeatureFromJson(String jsonSource) {
        List<News> articles = new ArrayList<>();
            if (TextUtils.isEmpty(jsonSource)) {
                return null;
            }
             try {

               JSONObject rootJsonResponse = new JSONObject(jsonSource);

                JSONObject responseJSONObject = rootJsonResponse.getJSONObject("response");
                JSONArray resultsJSONArray = responseJSONObject.getJSONArray("results");

                for (int i = 0; i < resultsJSONArray.length(); i++) {

                    JSONObject currentArticle = resultsJSONArray.getJSONObject(i);

                    String webPublDate = currentArticle.getString("webPublicationDate");

                    String title = currentArticle.getString("webTitle");

                    String section = currentArticle.getString("sectionName");
                    //TODO: dodaj autora i url
                    //String author = currentArticle.getString("tutaj pobaw sie w rozbijanie webTitle");

                    News article = new News(webPublDate, title, section);

                    articles.add(article);
                }

            } catch (JSONException e) {

                Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
            }

            return articles;
        }
    }

