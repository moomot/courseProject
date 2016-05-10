package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Movie;

public interface IMovieDAO {
	public void addMovie(Movie movie) throws SQLException;
	public void removeMovie(Movie movie) throws SQLException;
	public Movie getMovie(int id) throws SQLException;
	public List<Movie> getMovies() throws SQLException;
}
