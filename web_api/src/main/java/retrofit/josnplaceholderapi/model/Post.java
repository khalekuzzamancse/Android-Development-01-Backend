package retrofit.josnplaceholderapi.model;

import java.util.ArrayList;

public class Post {
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

  public Post(String userId, String id, String title, String body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public Post(){

  }
}
