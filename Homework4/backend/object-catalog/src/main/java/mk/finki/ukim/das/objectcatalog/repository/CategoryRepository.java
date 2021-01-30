package mk.finki.ukim.das.objectcatalog.repository;

import mk.finki.ukim.das.objectcatalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameIgnoreCase(String name);

}
