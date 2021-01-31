package mk.finki.ukim.das.objectcatalog.repository;

import mk.finki.ukim.das.objectcatalog.model.Category;
import mk.finki.ukim.das.objectcatalog.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ObjectRepository extends JpaRepository<Object, Long> {

    // returns a Set of Objects with the given name, ignores string's case
    Set<Object> findByNameIgnoreCaseContaining(String name);

    // returns a Set of Objects with the given address, ignores string's case
    Set<Object> findByAddressIgnoreCaseContaining(String city);

    // returns a Set of Objects with the given category
    Set<Object> findByCategory(Category category);

    // returns a Set of Objects with the given SmokingType
    Set<Object> findBySmokingType(Boolean smokingType);

    // returns a Set of Objects with the given OutdoorSeating type
    Set<Object> findByOutdoorSeating(Boolean seating);

}
