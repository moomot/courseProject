package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Cinema;

public interface ICinemaDAO {
	public void addCinema(Cinema cinema) throws SQLException;
	public void removeCinema(Cinema cinema) throws SQLException;
	public Cinema getCinema(int id) throws SQLException;
	public List<Cinema> getCinemas() throws SQLException;
}
