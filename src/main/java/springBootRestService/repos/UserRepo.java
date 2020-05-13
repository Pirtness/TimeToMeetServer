package springBootRestService.repos;

import org.springframework.data.repository.CrudRepository;
import springBootRestService.entities.User;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
