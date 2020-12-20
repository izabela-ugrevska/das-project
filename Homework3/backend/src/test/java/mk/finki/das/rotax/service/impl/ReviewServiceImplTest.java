package mk.finki.das.rotax.service.impl;

import mk.finki.das.rotax.model.Review;
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
    void findById() {
        Review review = new Review();
        review.setReviewId(1L);

        when(reviewRepository.findById(anyLong())).thenReturn(Optional.of(review));

        Review reviewReturned = reviewService.findById(1L);
        assertNotNull(reviewReturned);
        verify(reviewRepository).findById(anyLong());
    }

    @Test
    void saveReview() {
    }

    @Test
    void deleteById() {
        reviewService.deleteById(1L);
        verify(reviewRepository, times(1)).deleteById(anyLong());
    }
}