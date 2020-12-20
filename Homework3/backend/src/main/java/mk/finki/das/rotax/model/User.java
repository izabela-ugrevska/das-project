package mk.finki.das.rotax.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
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

    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    public User(Long userId, String username, String password, String firstName, String lastName, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        reviews = new HashSet<>();
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        reviews = new HashSet<>();
    }

    public User() {
        reviews = new HashSet<>();
    }

    public void addReview(Review r){
        reviews.add(r);
    }

}
