package mk.finki.das.rotax.controller;

import mk.finki.das.rotax.model.Object;
import mk.finki.das.rotax.model.Review;
import mk.finki.das.rotax.service.ObjectService;
import mk.finki.das.rotax.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/objects")
public class ObjectController {

    private final ObjectService objectService;

    private final ReviewService reviewService;

    public ObjectController(ObjectService objectService, ReviewService reviewService) {
        this.objectService = objectService;
        this.reviewService = reviewService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Object> getAllObjects(){
        return objectService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getObjectById(@PathVariable Long id){
        return objectService.findById(id);
    }

    @GetMapping("/category/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Object> getObjectsByCategoryName(@PathVariable String categoryName){
        return objectService.findByCategoryName(categoryName);
    }

    @PostMapping("/{objectId}/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@PathVariable Long objectId, @PathVariable Long userId, @RequestBody Review review){
        return reviewService.saveReview(review, userId, objectId);
    }

}