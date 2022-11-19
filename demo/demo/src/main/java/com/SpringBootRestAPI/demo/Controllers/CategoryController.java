package com.SpringBootRestAPI.demo.Controllers;


import com.SpringBootRestAPI.demo.Entity.Category;
import com.SpringBootRestAPI.demo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok().body(this.categoryService.createCategory(category));
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        category.setId(id);
        return ResponseEntity.ok().body(this.categoryService.updateCategory(category));
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @DeleteMapping("/category/{id}")
    public HttpStatus deleteCategory(@PathVariable int id) {
        this.categoryService.deleteCategory(id);
        return HttpStatus.OK;
    }


}
