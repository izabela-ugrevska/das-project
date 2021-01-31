package mk.finki.ukim.das.objectcatalog.service;

import mk.finki.ukim.das.objectcatalog.model.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> findAll();

    Category findById(Long id);

    Category findByName(String name);

    Object saveCategory(Category category);

    void deleteById(Long id);

}
