package mk.finki.das.rotax.repository;

import mk.finki.das.rotax.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObjectRepository extends JpaRepository<Object, Long> {

    Optional<Object> findByNameContaining(String name);

    Optional<Object> findByAddressContaining(String city);

    Optional<Object> findByCategoryName(String name);

    Optional<Object> findBySmokingType(Boolean smokingType);

    Optional<Object> findByOutdoorSeating(Boolean seating);

}
