package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Admin;

public interface IAdminDAO {
	public void addAdmin(Admin admin) throws SQLException;
	public void removeAdmin(Admin admin) throws SQLException;
	public Admin getAdmin(int id) throws SQLException;
	public List<Admin> getAdmins() throws SQLException;
}
