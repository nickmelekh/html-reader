import com.google.gson.Gson;

public class Item {
    private String name;
    private String image;
    private Offers offers;

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
