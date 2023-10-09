import org.jsoup.nodes.Element;

public class HotDealVO {
    private String store;
    private String badge;
    private String title;
    private Integer price;
    private String time;

    public HotDealVO(String store,String badge,String title,Integer price,String time) {
        this.store=store;
        this.badge=badge;
        this.title=title;
        this.price=price;
        this.time=time;
    }

    public String getStore() {
        return store;
    }

    public String getBadge() {
        return badge;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "HotDealDTO{" +
                "store=" + store +
                ", badge=" + badge +
                ", title=" + title +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}

