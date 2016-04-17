package evansitzes.requests;

/**
 * Created by evan on 4/17/16.
 */
public class CategoryRequest {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "category='" + category + '\'' +
                '}';
    }
}
