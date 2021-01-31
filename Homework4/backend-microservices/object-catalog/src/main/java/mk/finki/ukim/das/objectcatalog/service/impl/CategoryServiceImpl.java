package mk.finki.ukim.das.objectcatalog.service.impl;

import mk.finki.ukim.das.objectcatalog.model.Category;
import mk.finki.ukim.das.objectcatalog.repository.CategoryRepository;
import mk.finki.ukim.das.objectcatalog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // returns a Set of all categories
    @Override
    public Set<Category> findAll() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories;
    }

    // returns the category with the given ID
    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found!!!"));
    }

    // returns the category with the given name
    @Override
    public Category findByName(String name) {
        return categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Category Not Found!!!"));
    }

    // saves the given category to the database, returns the saved category
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // deletes the category with the given ID
    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
