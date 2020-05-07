package springBootRestService.repos;

import org.springframework.data.repository.CrudRepository;
import springBootRestService.entities.File;

public interface FileRepo extends CrudRepository<File, Long> {
}
