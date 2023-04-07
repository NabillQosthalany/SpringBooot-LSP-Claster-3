package com.latihanLsp.Export;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.latihanLsp.Model.Product;
import com.latihanLsp.Model.ProductWithCategory;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelCovert {
    private Workbook workbook;
    private Sheet sheet;
    private List<ProductWithCategory> products;

    public ExcelCovert(List<ProductWithCategory> productWithCategories) {
        this.products = productWithCategories;
        workbook = new XSSFWorkbook();
    }

    private void createHeader() {
        sheet = workbook.createSheet("Products");

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Amount Sold");
        header.createCell(1).setCellValue("Price");
        header.createCell(2).setCellValue("Stock");
        header.createCell(3).setCellValue("Tanggal Input");
        header.createCell(4).setCellValue("Name Category");
        header.createCell(5).setCellValue("Description");
        header.getCell(0).setCellStyle(style);
        header.getCell(1).setCellStyle(style);
        header.getCell(2).setCellStyle(style);
        header.getCell(3).setCellStyle(style);
        header.getCell(4).setCellStyle(style);
        header.getCell(5).setCellStyle(style);


    }

    private void createBody() {
        int rowNum = 1;
        for (ProductWithCategory product : products) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(product.getAmount_sold());
            row.createCell(1).setCellValue(product.getPrice());
            row.createCell(2).setCellValue(product.getStock());
            row.createCell(3).setCellValue(product.getTgl_input());
            row.createCell(4).setCellValue(product.getName_category());
            row.createCell(5).setCellValue(product.getDescription());


        }
    }

    public void export(OutputStream outputStream) throws IOException {
        createHeader();
        createBody();
        workbook.write(outputStream);
        workbook.close();
    }
}
