package com.example.android.newsappabnd;

public class News {
    //TODO: dodaj url i autora
    private String mWebPublDate;
    private String mTitle;
    private String mSection;

    public News(String webPublDate, String title, String section){
        mWebPublDate = webPublDate;
        mTitle = title;
        mSection = section;
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
}
