package mk.finki.das.rotax.service;

import mk.finki.das.rotax.model.Review;

import java.util.Set;

public interface ReviewService {

    Set<Review> findByObject(Long objectId);

    Review findById(Long userId, Long objectId);

    Review saveReview(Review review, Long userId, Long objectId);

    void deleteById(Long userId, Long objectId);

}
