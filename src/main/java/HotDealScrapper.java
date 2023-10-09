import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HotDealScrapper {
    public static void main(String[] args) {
        String urlBase = "https://arca.live/b/hotdeal?p=";
        int pageStart = 1;
        int pageEnd = 2;
        try{
            ArrayList<HotDealVO> data = new ArrayList<>();
            for (int page = pageStart;page<=pageEnd;page++){
                String url = urlBase+page;
                Document document = Jsoup.connect(url).get();

                Elements store = document.select(".deal-store");
                Elements badge = document.select(".badge");
                Elements title = document.select(".hybrid-title");
                Elements price = document.select(".deal-price");
                Elements time = document.select(".col-time");

                for (int i=0;i<store.size();i++){
                    System.out.println(store.get(i).text()+"/"+badge.get(i).text()+"/"+title.get(i).text()+"/"+price.get(i).text()+"/"+time.get(i).text());
                    data.add(new HotDealVO(
                            store.get(i).text(),
                            badge.get(i).text(),
                            title.get(i).text(),
                            Integer.parseInt(price.get(i).text().replaceAll("[\\D]","")),
                            time.get(i).text()));

                }
            }
            String savePath = "src/main/sample_output/";
            LocalDateTime now = java.time.LocalDateTime.now();
            String excelFileName = "hotdeal_status_"+now.getYear()+now.getMonthValue()+now.getDayOfMonth()+now.getHour()+now.getMinute();
            ExcelExporter.exportToExcel(data,excelFileName,savePath);
            System.out.println("엑셀 파일로 저장 완료: "+excelFileName);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}