package retrofit.nprnews.model;

import java.util.ArrayList;

public class Feed {
    public String description;
    public FeedAuthor author;
    public ArrayList<FeedItem> items;

    @Override
    public String toString() {
        return "Feed{" +
                "description='" + description + '\'' +
                ", feedAuthor=" + author +
                ", items=" + items +
                '}';
    }
}
