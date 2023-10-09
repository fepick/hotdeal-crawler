import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelExporter {
    public static void exportToExcel(ArrayList<HotDealVO> datas,String filename,String savepath) throws IOException {

        int startingRow = 1;

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("핫딜");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("스토어");
        headerRow.createCell(1).setCellValue("분류");
        headerRow.createCell(2).setCellValue("제목");
        headerRow.createCell(3).setCellValue("가격");
        headerRow.createCell(4).setCellValue("시간");

        for (HotDealVO data:datas){
            Row row = sheet.createRow(startingRow);
            row.createCell(0).setCellValue(data.getStore());
            row.createCell(1).setCellValue(data.getBadge());
            row.createCell(2).setCellValue(data.getTitle());
            row.createCell(3).setCellValue(data.getPrice());
            row.createCell(4).setCellValue(data.getTime());
            startingRow++;
        }
        FileOutputStream outputStream = new FileOutputStream(new File(savepath+filename));
        workbook.write(outputStream);
        workbook.close();
    }
}

