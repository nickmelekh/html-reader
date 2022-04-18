import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GetContent {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.ozon.ru/product/smartfon-apple-iphone-13-pro-max-128gb-nebesno-goluboy-315311022/?asb=4b2B2JrSX1EvUlWl50XYrZqy1ATsAVifsGrQUaH6c8c%253D&asb2=lfxUBjqo2ChkIrIHM3-T8d5S-iFj1QVg3ns8umw3bDmGyWljQCu1Dbl6WhqSqeMa&keywords=13+pro+max&sh=8kx_cDRqsg").get();
            // doc = Jsoup.connect("https://en.wikipedia.org/").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements selectResult = doc.select("script[type=application/ld+json]");

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        for (Element elem : selectResult) {

            Item item = gson.fromJson(elem.html(), Item.class);

            System.out.println(item.getOffers().getPrice());
        }
    }
}