package retrofit.nprnews.model;

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
