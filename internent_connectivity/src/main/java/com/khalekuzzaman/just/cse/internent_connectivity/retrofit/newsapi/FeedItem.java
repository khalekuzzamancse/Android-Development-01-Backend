package com.khalekuzzaman.just.cse.internent_connectivity.retrofit.newsapi;

public class FeedItem {
    public String url;
    public String title;

    @Override
    public String toString() {
        return "FeedItem{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
