package com.example.android.newsappabnd;

public class News {
    //TODO: dodaj autora
    private String mWebPublDate;
    private String mTitle;
    private String mSection;
    private String mUrl;

    public News(String webPublDate, String title, String section, String articleUrl){
        mWebPublDate = webPublDate;
        mTitle = title;
        mSection = section;
        mUrl = articleUrl;
    }

    public String getWebPublDate(){
        return mWebPublDate;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getSection(){
        return mSection;
    }

    public String getUrl() {
        return mUrl;
    }
}
