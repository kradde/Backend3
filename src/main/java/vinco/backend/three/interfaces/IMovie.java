package vinco.backend.three.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vinco.backend.three.models.Movie;

@Repository
public interface IMovie extends CrudRepository<Movie, Integer> {
    
}
