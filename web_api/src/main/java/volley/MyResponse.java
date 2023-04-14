package volley;

public class MyResponse {
    public String title;
    public String description;

    @Override
    public String toString() {
        return "CustomAPIResponse{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
