package delicacies.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(name = "USER_UK", columnNames = "username")})
public class DelicaciesUserEntity {
	@Id
	@GeneratedValue
	@Column(name = "id", length = 11, nullable = false)
	private int id;
	
	@Column(name = "username", length = 255, nullable = false)
	private String username;
	
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEncrytedPassword(String password) {
		this.password = password;
	}
	
	public String getEncrytedPassword() {
		return this.password;
	}
}
