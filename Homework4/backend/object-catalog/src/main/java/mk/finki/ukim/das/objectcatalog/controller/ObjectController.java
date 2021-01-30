package mk.finki.ukim.das.objectcatalog.controller;

import mk.finki.ukim.das.objectcatalog.model.Object;
import mk.finki.ukim.das.objectcatalog.model.Review;
import mk.finki.ukim.das.objectcatalog.service.ObjectService;
import mk.finki.ukim.das.objectcatalog.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "https://rotax-app.herokuapp.com/")
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

    @PostMapping("/{objectId}/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@PathVariable Long objectId, @PathVariable String username, @RequestBody Review review){
        return reviewService.saveReview(review, username, objectId);
    }

}