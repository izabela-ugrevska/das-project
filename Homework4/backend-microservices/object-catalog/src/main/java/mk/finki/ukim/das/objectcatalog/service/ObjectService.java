package mk.finki.ukim.das.objectcatalog.service;

import mk.finki.ukim.das.objectcatalog.model.Object;

import java.util.Set;

public interface ObjectService {

    // returns a Set of all objects in the database
    Set<Object> findAll();

    // returns the object with the given ID
    Object findById(Long id);

    // saves the given object, returns the saved object
    Object saveObject(Object object);

    // deletes the object with the given ID
    void deleteById(Long id);

    // returns a Set of Objects with the given category name
    Set<Object> findByCategoryName(String name);

}
