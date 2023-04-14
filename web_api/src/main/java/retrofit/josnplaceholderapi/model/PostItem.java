package retrofit.josnplaceholderapi.model;

public class PostItem {
    public String userId;
    public String id;
    public String title;
    public String body;

    @Override
    public String toString() {
        return "EachPost{" +
                "userId='" + userId + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
