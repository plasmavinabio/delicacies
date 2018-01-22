package delicacies.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "role",uniqueConstraints = {@UniqueConstraint(name = "ROLE_UK", columnNames = "code")})
public class DelicaciesRoleEntity {
	@Id
	@GeneratedValue
	@Column(name = "id", length = 11, nullable = false)
	private int id;
	
	@Column(name = "code", length = 255, nullable = false)
	private String code;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
