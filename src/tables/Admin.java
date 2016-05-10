package tables;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin", catalog = "cinema")
public class Admin implements Serializable {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admin_id", unique = true, nullable = false)
	private int admin_id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
