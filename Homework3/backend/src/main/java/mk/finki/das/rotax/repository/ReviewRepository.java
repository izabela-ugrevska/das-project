package mk.finki.das.rotax.repository;

import mk.finki.das.rotax.model.Review;
import mk.finki.das.rotax.model.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, ReviewId> {

    List<Review> findAllByReviewIdObjectId(Long objectId);

    List<Review> findAllByReviewIdUserId(Long objectId);

}
