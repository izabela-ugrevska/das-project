package mk.finki.ukim.das.objectcatalog.repository;

import mk.finki.ukim.das.objectcatalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // returns the Category with the given name, ignores string's case
    Optional<Category> findByNameIgnoreCase(String name);

}
