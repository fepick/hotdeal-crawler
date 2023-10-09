import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HotDealScrapper {
    public static void main(String[] args) {
        String urlBase = "https://arca.live/b/hotdeal?p=";
        int page = 1;
        try{
            String url = urlBase+page;
            Document document = Jsoup.connect(url).get();

            Element asd = document.getElementById("info");
            /*
            Element store=document.getElementById("deal-store");
            Element badge=document.getElementById("badge");
            Element title=document.getElementById("title hybrid-title");
            Element price=document.getElementById("deal-price");
             */

            Elements store = document.select(".deal-store");
            Elements badge = document.select(".badge");
            Elements title = document.select(".hybrid-title");
            Elements price = document.select(".deal-price");

            for (int i=0;i<store.size();i++){
                System.out.println(store.get(i).text()+":"+price.get(i).text());
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
