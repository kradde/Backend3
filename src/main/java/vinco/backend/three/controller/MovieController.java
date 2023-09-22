package vinco.backend.three.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vinco.backend.three.interfaceServices.IMovieService;
import vinco.backend.three.models.Movie;

@Controller
@RequestMapping()
public class MovieController {

    @Autowired
    private IMovieService service;

    @GetMapping("/index")
    public String getAll(Model model) {
        List<Movie> movies = service.getAll();
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/add")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String editMovieForm(@PathVariable("id") int id, Model model) {
        Movie movie = service.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("movie", movie);
        return "update";
    }

    @PostMapping("/addmovie")
    public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }

        service.save(movie);
        return "redirect:/index";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") int id, @Valid Movie movie,
            BindingResult result, Model model) {
        movie.setMovie_id(id);
        if (result.hasErrors()) {
            return "update";
        }

        service.save(movie);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        Movie movie = service.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        service.delete(id);
        return "redirect:/index";
    }
}
