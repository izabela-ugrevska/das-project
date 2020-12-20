package mk.finki.das.rotax.service;

import mk.finki.das.rotax.model.Review;

import java.util.Set;

public interface ReviewService {

    Review findById(Long id);

    Review saveReview(Review review, String username, Long objectId);

    void deleteById(Long id);

}
