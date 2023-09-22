package vinco.backend.three.interfaceServices;

import java.util.List;
import java.util.Optional;
import vinco.backend.three.models.Movie;

public interface IMovieService {
    public List<Movie> getAll();
    public Optional<Movie> getById(int id);
    public int save(Movie m);
    public void delete(int id);
}
