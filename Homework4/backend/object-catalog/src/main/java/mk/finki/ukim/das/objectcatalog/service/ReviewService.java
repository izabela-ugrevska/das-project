package mk.finki.ukim.das.objectcatalog.service;

import mk.finki.ukim.das.objectcatalog.model.Review;

public interface ReviewService {

    Review findById(Long id);

    Review saveReview(Review review, String username, Long objectId);

    void deleteById(Long id);

}
