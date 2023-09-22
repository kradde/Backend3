package vinco.backend.three.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vinco.backend.three.interfaceServices.IMovieService;
import vinco.backend.three.interfaces.IMovie;
import vinco.backend.three.models.Movie;
import vinco.backend.three.models.Seat;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovie data;
    
    @Override
    public List<Movie> getAll() {
        return (List<Movie>)data.findAll();
    }

    @Override
    public Optional<Movie> getById(int id) {
        return (Optional<Movie>)data.findById(id);
    }

    @Override
    public int save(Movie m) {
        List<Seat> listSeats = new ArrayList<>();
        
        for (int i = 1; i <= m.getRows(); i++) {
            for (int j = 1; j <= m.getColumns(); j++) {
                listSeats.add(new Seat(i, j, m));
            }
        }
        m.setListSeats(listSeats);
        
        int res = 0;
        Movie movie = data.save(m);
        if (!movie.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
    
}
