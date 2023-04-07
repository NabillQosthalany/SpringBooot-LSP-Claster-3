package com.latihanLsp.Controller;

import com.latihanLsp.Model.ProductWithCategory;
import com.latihanLsp.RepoImpl.ProductRepoImpl;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExportController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductRepoImpl productRepo;

    @RequestMapping(value = "/exportExcel/{tanggal}", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response, @PathVariable("tanggal") String tanggal) throws Exception {

        // Buat data model
        List<ProductWithCategory> products = getDataByTanggal(tanggal);

        // Buat file Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("products");
        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Amount Sold");
        headerRow.createCell(1).setCellValue("Price");
        headerRow.createCell(2).setCellValue("Stock");
        headerRow.createCell(3).setCellValue("Tanggal Input");



        for (ProductWithCategory product : products) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(product.getAmount_sold());
            row.createCell(1).setCellValue(product.getPrice());
            row.createCell(2).setCellValue(product.getStock());
            row.createCell(3).setCellValue(product.getTgl_input());

        }

        // Set response header
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=data.xlsx");

        // Write ke output stream
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
        out.close();
    }
    private List<ProductWithCategory> getDataByTanggal(String tanggal) {
        String sql = "SELECT * FROM `pwithc` WHERE tgl_input = ?";
        return jdbcTemplate.query(sql, new Object[]{tanggal}, new RowMapper<ProductWithCategory>() {
            @Override
            public ProductWithCategory mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductWithCategory data = new ProductWithCategory();
                data.setPrice(resultSet.getInt("price"));
                data.setAmount_sold(resultSet.getInt("amount_sold"));
                data.setStock(resultSet.getInt("stock"));
                data.setTgl_input(resultSet.getDate("tgl_input"));
                return data;
            }
        });
    }



}
