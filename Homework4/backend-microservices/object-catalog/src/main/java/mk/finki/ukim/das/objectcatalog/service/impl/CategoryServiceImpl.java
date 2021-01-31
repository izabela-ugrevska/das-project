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

    @Override
    public Set<Category> findAll() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found!!!"));
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Category Not Found!!!"));
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
