package mk.finki.das.rotax.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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

}
