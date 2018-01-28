package delicacies.entity.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class DelicaciesLanguageEntity {
	@Id
	@GeneratedValue
	@Column(name = "id", length = 3, nullable = false)
	private int id;
	
	@Column(name = "code", length = 32, nullable = false)
	private String code;
	
	@Column(name = "name", length = 128, nullable = false)
	private String name;
	
	@Column(name = "active")
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
