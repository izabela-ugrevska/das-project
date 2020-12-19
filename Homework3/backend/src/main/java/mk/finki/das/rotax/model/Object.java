package mk.finki.das.rotax.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "objects")
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Long objectId;

    private String name;

    private String longitude;

    private String latitude;

    private String phone;

    private String website;

    private Boolean smokingType;

    private Boolean outdoorSeating;

    private String openingHours;

    private String address;

    private String cuisine;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "object")
    private Set<Review> reviews;

    public Object(Long objectId, String name, String longitude, String latitude, String phone, String website,
                  Boolean smokingType, Boolean outdoorSeating, String openingHours, String address, String cuisine,
                  Category category) {
        this.objectId = objectId;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.website = website;
        this.smokingType = smokingType;
        this.outdoorSeating = outdoorSeating;
        this.openingHours = openingHours;
        this.address = address;
        this.cuisine = cuisine;
        this.category = category;
        reviews = new HashSet<>();
    }

    public Object() {
        reviews = new HashSet<>();
    }

    public void addReview(Review r){
        reviews.add(r);
    }
}
