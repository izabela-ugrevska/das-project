package mk.finki.ukim.das.objectcatalog.service.impl;

import mk.finki.ukim.das.objectcatalog.model.Category;
import mk.finki.ukim.das.objectcatalog.model.Object;
import mk.finki.ukim.das.objectcatalog.repository.CategoryRepository;
import mk.finki.ukim.das.objectcatalog.repository.ObjectRepository;
import mk.finki.ukim.das.objectcatalog.service.ObjectService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ObjectServiceImpl implements ObjectService {

    private final ObjectRepository objectRepository;

    private final CategoryRepository categoryRepository;

    public ObjectServiceImpl(ObjectRepository objectRepository, CategoryRepository categoryRepository) {
        this.objectRepository = objectRepository;
        this.categoryRepository = categoryRepository;
    }

    // returns a Set of all objects in the database
    @Override
    public Set<Object> findAll() {
        Set<Object> objects = new HashSet<>();
        objectRepository.findAll().iterator().forEachRemaining(objects::add);
        return objects;
    }

    // returns the object with the given ID
    @Override
    public Object findById(Long id) {
        return objectRepository.findById(id).orElseThrow(() -> new RuntimeException("Object Not Found!!!"));
    }

    // saves the given object, returns the saved object
    @Override
    public Object saveObject(Object object) {
        return objectRepository.save(object);
    }

    // deletes the object with the given ID
    @Override
    public void deleteById(Long id) {
        objectRepository.deleteById(id);
    }

    // returns a Set of Objects with the given category name
    @Override
    public Set<Object> findByCategoryName(String name) {
        Category category = categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Category Not Found!!!"));
        return objectRepository.findByCategory(category);
    }

}
