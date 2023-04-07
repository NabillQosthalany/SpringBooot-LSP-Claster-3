package com.latihanLsp.Controller;

import com.latihanLsp.Export.ExcelCovert;
import com.latihanLsp.Model.LogPenjualan;
import com.latihanLsp.Model.Product;
import com.latihanLsp.Model.ProductWithCategory;
import com.latihanLsp.RepoImpl.ProductRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
    @Autowired
    private ProductRepoImpl productRepo;

    @PostMapping("/product")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        productRepo.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        productRepo.updateProduct(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productRepo.deleteAnimal(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productRepo.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> product = productRepo.getAllProduct();
        return ResponseEntity.ok(product);
    }
    @GetMapping("/with-category")
    public List<ProductWithCategory> getProductsWithCategory() {
        return productRepo.getProductsWithCategory();
    }
    @GetMapping("/penjualan")
    public List<LogPenjualan> getLogPenjualan() {
        return productRepo.getLogPenjualan();
    }
    @GetMapping("/products/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=product.xlsx");

        List<ProductWithCategory> productWithCategories = productRepo.getProductsWithCategory();
        ExcelCovert exporter = new ExcelCovert(productWithCategories);
        exporter.export(response.getOutputStream());
    }


}
