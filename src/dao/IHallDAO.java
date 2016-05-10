package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Hall;

public interface IHallDAO {
	public void addHall(Hall hall) throws SQLException;
	public void removeHall(Hall hall) throws SQLException;
	public Hall getHall(int id) throws SQLException;
	public List<Hall> getHalls() throws SQLException;
}
