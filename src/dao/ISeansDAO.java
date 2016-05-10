package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Seans;

public interface ISeansDAO {
	public void addSeans(Seans seans) throws SQLException;
	public void removeSeans(Seans seans) throws SQLException;
	public Seans getSeans(int id) throws SQLException;
	public List<Seans> getSeanses() throws SQLException;
}
