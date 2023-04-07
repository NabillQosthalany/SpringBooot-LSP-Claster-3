package com.latihanLsp.Repo;

import com.latihanLsp.Model.Category;
import com.latihanLsp.Model.Product;

import java.util.List;

public interface CategoryRepo {
    void addCategory(Category Category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category getCategoryById(int id);
    List<Category> getAllCategory();
}
