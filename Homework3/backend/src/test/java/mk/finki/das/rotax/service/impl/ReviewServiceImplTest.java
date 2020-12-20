package mk.finki.das.rotax.service.impl;

import mk.finki.das.rotax.model.Review;
import mk.finki.das.rotax.model.ReviewId;
import mk.finki.das.rotax.repository.ObjectRepository;
import mk.finki.das.rotax.repository.ReviewRepository;
import mk.finki.das.rotax.repository.UserRepository;
import mk.finki.das.rotax.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReviewServiceImplTest {

    ReviewService reviewService;

    @Mock
    ReviewRepository reviewRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    ObjectRepository objectRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reviewService = new ReviewServiceImpl(userRepository, objectRepository, reviewRepository);
    }

    @Test
    void findByObject() {
        List<Review> reviewList = new ArrayList<>();
        Review review1 = new Review();
        review1.setReviewId(new ReviewId(1L, 1L));
        reviewList.add(review1);
        Review review2 = new Review();
        review2.setReviewId(new ReviewId(2L, 2L));
        reviewList.add(review2);

        when(reviewRepository.findAllByReviewIdObjectId(anyLong())).thenReturn(reviewList);

        Set<Review> reviews = reviewService.findByObject(1L);
        assertEquals(reviews.size(), 2);
        verify(reviewRepository, times(1)).findAllByReviewIdObjectId(anyLong());
    }

    @Test
    void findById() {
        Review review = new Review();
        ReviewId reviewId = new ReviewId(1L, 1L);
        review.setReviewId(reviewId);

        when(reviewRepository.findById(any(ReviewId.class))).thenReturn(Optional.of(review));

        Review reviewReturned = reviewService.findById(1L, 1L);
        assertNotNull(reviewReturned);
        verify(reviewRepository).findById(any(ReviewId.class));
    }

    @Test
    void saveReview() {
    }

    @Test
    void deleteById() {
        reviewService.deleteById(1L, 1L);
        verify(reviewRepository, times(1)).deleteById(any(ReviewId.class));
    }
}