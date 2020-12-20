package mk.finki.das.rotax.repository;

import mk.finki.das.rotax.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
