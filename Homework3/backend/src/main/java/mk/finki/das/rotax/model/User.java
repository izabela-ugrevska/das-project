package mk.finki.das.rotax.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    public User(Long userId, String username, String password, String firstName, String lastName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        reviews = new HashSet<>();
    }

    public User() {
        reviews = new HashSet<>();
    }

    public void addReview(Review r){
        reviews.add(r);
    }

}
