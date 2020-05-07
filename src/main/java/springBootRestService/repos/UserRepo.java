package springBootRestService.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import springBootRestService.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
