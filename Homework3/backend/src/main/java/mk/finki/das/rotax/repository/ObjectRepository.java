package mk.finki.das.rotax.repository;

import mk.finki.das.rotax.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObjectRepository extends JpaRepository<Object, Long> {

    Optional<Object> findByNameIgnoreCaseContaining(String name);

    Optional<Object> findByAddressIgnoreCaseContaining(String city);

    Optional<Object> findByCategoryNameIgnoreCase(String name);

    Optional<Object> findBySmokingType(Boolean smokingType);

    Optional<Object> findByOutdoorSeating(Boolean seating);

}
