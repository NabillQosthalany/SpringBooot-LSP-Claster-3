package com.latihanLsp.Controller;

import com.latihanLsp.Model.Category;
import com.latihanLsp.Model.Product;
import com.latihanLsp.RepoImpl.CategoryImpl;
import com.latihanLsp.RepoImpl.ProductRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CategoryController {
    @Autowired
    private CategoryImpl categoryImpl;

    @PostMapping("/category")
    public ResponseEntity<Void> addCategory(@RequestBody Category category) {
        categoryImpl.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable int id, @RequestBody Category category) {
        category.setId(id);
        categoryImpl.updateCategory(category);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoryImpl.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category category = categoryImpl.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> category = categoryImpl.getAllCategory();
        return ResponseEntity.ok(category);
    }
}
