package mk.finki.ukim.das.objectcatalog.repository;

import mk.finki.ukim.das.objectcatalog.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
