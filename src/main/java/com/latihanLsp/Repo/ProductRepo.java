package com.latihanLsp.Repo;

import com.latihanLsp.Model.LogPenjualan;
import com.latihanLsp.Model.Product;
import com.latihanLsp.Model.ProductWithCategory;

import java.util.List;

public interface ProductRepo {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteAnimal(int id);
    Product getProductById(int id);
    List<Product> getAllProduct();
    List<ProductWithCategory> getProductsWithCategory();
    List<LogPenjualan> getLogPenjualan();

}
