package mk.finki.das.rotax.service;

import mk.finki.das.rotax.model.Object;

import java.util.Set;

public interface ObjectService {

    Set<Object> findAll();

    Object findById(Long id);

    Object saveObject(Object object);

    void deleteById(Long id);

    Set<Object> findByName(String name);

    Set<Object> findByCity(String city);

    Set<Object> findByCategoryName(String name);

    Set<Object> findBySmokingType(Boolean smokingType);

    Set<Object> findByOutdoorSeating(Boolean seating);

}
