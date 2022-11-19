package com.SpringBootRestAPI.demo.Service;

import com.SpringBootRestAPI.demo.Entity.Category;
import com.SpringBootRestAPI.demo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> categoryDb = this.categoryRepository.findById(category.getId());

        if(categoryDb.isPresent()) {
            Category categoryUpdate = categoryDb.get();
            categoryUpdate.setId(category.getId());
            categoryUpdate.setCategoryName(category.getCategoryName());
            categoryUpdate.setDescription(category.getDescription());
            categoryRepository.save(categoryUpdate);
            return categoryUpdate;
        }

        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        Optional<Category> categoryDb = this.categoryRepository.findById(id);

        if(categoryDb.isPresent()) {
            return categoryDb.get();
        }

        return null;
    }

    @Override
    public void deleteCategory(int id) {
        Optional<Category> categoryDb = this.categoryRepository.findById(id);

        if(categoryDb.isPresent()) {
            this.categoryRepository.delete(categoryDb.get());
        }
    }


}
