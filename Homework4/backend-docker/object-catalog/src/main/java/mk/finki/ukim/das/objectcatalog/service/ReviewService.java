package mk.finki.ukim.das.objectcatalog.service;

import mk.finki.ukim.das.objectcatalog.model.Review;

public interface ReviewService {

    // returns the review with the given ID
    Review findById(Long id);

    // saves the review, returns the saved review
    Review saveReview(Review review, Long userId, Long objectId);

    // deletes the review with the given id
    void deleteById(Long id);

}
