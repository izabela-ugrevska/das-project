package mk.finki.das.rotax.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
public class ReviewId implements Serializable {

    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "user_id")
    private Long userId;

}
