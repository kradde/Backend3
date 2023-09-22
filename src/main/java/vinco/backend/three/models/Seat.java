package vinco.backend.three.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="seats")
public class Seat {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic
    private int seat_id;
    private int row;
    private int col;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie.movie_id")
    private Movie movie;

    public Seat() {}
    
    public Seat(int row, int col, Movie movie) {
        this.row = row;
        this.col = col;
        this.movie = movie;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
