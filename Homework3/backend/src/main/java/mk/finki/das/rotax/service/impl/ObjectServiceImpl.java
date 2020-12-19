package mk.finki.das.rotax.service.impl;

import mk.finki.das.rotax.model.Category;
import mk.finki.das.rotax.model.Object;
import mk.finki.das.rotax.repository.CategoryRepository;
import mk.finki.das.rotax.repository.ObjectRepository;
import mk.finki.das.rotax.service.ObjectService;
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

    @Override
    public Set<Object> findAll() {
        Set<Object> objects = new HashSet<>();
        objectRepository.findAll().iterator().forEachRemaining(objects::add);
        return objects;
    }

    @Override
    public Object findById(Long id) {
        return objectRepository.findById(id).orElseThrow(() -> new RuntimeException("Object Not Found!!!"));
    }

    @Override
    public Object saveObject(Object object) {
        return objectRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        objectRepository.deleteById(id);
    }

    @Override
    public Set<Object> findByName(String name) {
        return objectRepository.findByNameIgnoreCaseContaining(name);
    }

    @Override
    public Set<Object> findByCity(String city) {
        return objectRepository.findByAddressIgnoreCaseContaining(city);
    }

    @Override
    public Set<Object> findByCategoryName(String name) {
        Category category = categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Category Not Found!!!"));
        return objectRepository.findByCategory(category);
    }

    @Override
    public Set<Object> findByOutdoorSeating(Boolean outdoorSeating) {
        return objectRepository.findByOutdoorSeating(outdoorSeating);
    }

    @Override
    public Set<Object> findBySmokingType(Boolean smokingType) {
        return objectRepository.findBySmokingType(smokingType);
    }

}
