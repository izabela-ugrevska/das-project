package mk.finki.das.rotax.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @EmbeddedId
    private ReviewId reviewId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("objectId")
    @JoinColumn(name = "object_id")
    private Object object;

    private String comment;

    private Integer rating;

}
