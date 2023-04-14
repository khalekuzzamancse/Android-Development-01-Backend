package retrofit.nprnews.model;

public class FeedAuthor {
    public String name;
    public String url;
    public String avatar;

    @Override
    public String toString() {
        return "FeedAuthor{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}

