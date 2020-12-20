package mk.finki.das.rotax.repository;

import mk.finki.das.rotax.model.Category;
import mk.finki.das.rotax.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ObjectRepository extends JpaRepository<Object, Long> {

    Set<Object> findByNameIgnoreCaseContaining(String name);

    Set<Object> findByAddressIgnoreCaseContaining(String city);

    Set<Object> findByCategory(Category category);

    Set<Object> findBySmokingType(Boolean smokingType);

    Set<Object> findByOutdoorSeating(Boolean seating);

}
