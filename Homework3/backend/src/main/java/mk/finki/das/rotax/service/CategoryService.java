package mk.finki.das.rotax.service;

import mk.finki.das.rotax.model.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> findAll();

    Category findById(Long id);

    Category findByName(String name);

    Object saveCategory(Category category);

    void deleteById(Long id);

}
