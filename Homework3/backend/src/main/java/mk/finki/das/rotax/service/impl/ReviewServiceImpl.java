package mk.finki.das.rotax.service.impl;

import mk.finki.das.rotax.model.Object;
import mk.finki.das.rotax.model.Review;
import mk.finki.das.rotax.model.User;
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
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review Not Found!!!"));
    }

    @Override
    public Review saveReview(Review review, String username, Long objectId) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not Found!!!"));
        Object object = objectRepository.findById(objectId).orElseThrow(() -> new RuntimeException("Object Not Found!!!"));
        review.setObject(object);
        review.setUser(user);
        Review reviewSaved = reviewRepository.save(review);
        object.addReview(reviewSaved);
        objectRepository.save(object);
        return reviewSaved;
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
