package mk.finki.das.rotax.service.impl;

import mk.finki.das.rotax.model.Review;
import mk.finki.das.rotax.model.ReviewId;
import mk.finki.das.rotax.repository.ObjectRepository;
import mk.finki.das.rotax.repository.ReviewRepository;
import mk.finki.das.rotax.repository.UserRepository;
import mk.finki.das.rotax.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final UserRepository userRepository;

    private final ObjectRepository objectRepository;

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(UserRepository userRepository, ObjectRepository objectRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.objectRepository = objectRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Set<Review> findByObject(Long objectId) {
        Set<Review> reviews = new HashSet<>();
        reviewRepository.findAllByReviewIdObjectId(objectId).iterator().forEachRemaining(reviews::add);
        return reviews;
    }

    @Override
    public Review findById(Long userId, Long objectId) {
        ReviewId id = new ReviewId(objectId, userId);
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review Not Found!!!"));
    }

    @Override
    public Review saveReview(Review review, Long userId, Long objectId) {
        ReviewId id = new ReviewId(objectId, userId);
        review.setReviewId(id);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long userId, Long objectId) {
        ReviewId id = new ReviewId(objectId, userId);
        reviewRepository.deleteById(id);
    }
}
