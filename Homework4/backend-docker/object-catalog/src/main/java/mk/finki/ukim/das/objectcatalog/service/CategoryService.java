package mk.finki.ukim.das.objectcatalog.service;

import mk.finki.ukim.das.objectcatalog.model.Category;

import java.util.Set;

public interface CategoryService {

    // returns a Set of all categories
    Set<Category> findAll();

    // returns the category with the given ID
    Category findById(Long id);

    // returns the category with the given name
    Category findByName(String name);

    // saves the given category to the database, returns the saved category
    Object saveCategory(Category category);

    // deletes the category with the given ID
    void deleteById(Long id);

}
