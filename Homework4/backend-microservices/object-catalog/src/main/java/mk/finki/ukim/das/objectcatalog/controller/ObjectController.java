package mk.finki.ukim.das.objectcatalog.controller;

import mk.finki.ukim.das.objectcatalog.model.Object;
import mk.finki.ukim.das.objectcatalog.model.Review;
import mk.finki.ukim.das.objectcatalog.service.ObjectService;
import mk.finki.ukim.das.objectcatalog.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/objects")
public class ObjectController {

    private final RestTemplate restTemplate;

    private final ObjectService objectService;

    private final ReviewService reviewService;

    public ObjectController(RestTemplate restTemplate, ObjectService objectService, ReviewService reviewService) {
        this.restTemplate = restTemplate;
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

        Long userId = restTemplate.getForObject("http://localhost:8082/users/" + username, Long.class);

        return reviewService.saveReview(review, userId, objectId);
    }

}