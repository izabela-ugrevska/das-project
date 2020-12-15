package mk.finki.das.rotax.repository;

import mk.finki.das.rotax.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
