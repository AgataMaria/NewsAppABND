package com.example.android.newsappabnd;

public class News {
    private String mWebPublDate;
    private String mTitle;
    private String mSection;
    private String mUrl;
    private String mAuthor;

    public News(String webPublDate, String title, String section, String articleUrl, String author){
        mWebPublDate = webPublDate;
        mTitle = title;
        mSection = section;
        mUrl = articleUrl;
        mAuthor = author;
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

    public String getAuthor() {return mAuthor; }
}
