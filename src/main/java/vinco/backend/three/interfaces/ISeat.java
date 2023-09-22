package vinco.backend.three.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vinco.backend.three.models.Seat;

@Repository
public interface ISeat extends CrudRepository<Seat, Integer> {
    
}
